package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import com.project.board.board.domain.QBoard;
import com.project.board.board.search.BoardSearchCondition;
import com.project.board.member.domain.QMember;
import com.project.board.reply.domain.QReply;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;
import static org.apache.logging.log4j.util.Strings.isEmpty;
import javax.persistence.EntityManager;

import java.util.List;

import static com.project.board.board.domain.QBoard.board;
import static com.project.board.member.domain.QMember.member;
import static com.project.board.reply.domain.QReply.reply;
import static org.springframework.util.StringUtils.*;

public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Page<Board> searchAllCondition(int groupId,BoardSearchCondition searchCondition, Pageable pageable) {
        List<Board> result = queryFactory
                .select(board).distinct()
                .from(board)
                .join(board.member,member).fetchJoin()
//                .leftJoin(board.replies,reply)
                .where(
                        usernameOrTitleEq(searchCondition.getAll())
                        ,usernameEq(searchCondition.getName())
                        ,titleEq(searchCondition.getTitle())
                        ,board.groupId.eq(groupId)
                )
                .orderBy(boardSort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(board.count()).distinct()
                .from(board)
                .join(board.member,member)
//                .join(board.replies,reply)
                .where(
                        usernameOrTitleEq(searchCondition.getAll())
                        ,usernameEq(searchCondition.getName())
                        ,titleEq(searchCondition.getTitle())
                        ,board.groupId.eq(groupId)
                );
        return PageableExecutionUtils.getPage(result,pageable,CountQuery::fetchOne);
    }
    /**
     * OrderSpecifier ??? ????????? ???????????? ??????????????? ????????????.
     * ????????? ??????
     * @param page
     * @return
     */
    private OrderSpecifier<?> boardSort(Pageable page) {
        //??????????????? ????????? Pageable ????????? ???????????? null ??? ??????
        if (!page.getSort().isEmpty()) {
            //???????????? ?????? ????????? for ???????????? ?????? ????????????
            for (Sort.Order order : page.getSort()) {
                // ??????????????? ????????? DESC or ASC ??? ????????????.
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                // ??????????????? ????????? ?????? ????????? ????????? ????????? ?????? ???????????? ???????????? ??????.
                switch (order.getProperty()){
                    case "id":
                        return new OrderSpecifier(direction, board.id);
                    case "title":
                        return new OrderSpecifier(direction, board.title);
                    case "content":
                        return new OrderSpecifier(direction, board.content);
                    case "member":
                        return new OrderSpecifier(direction, board.member.name);
                    case "createdDate":
                        return new OrderSpecifier(direction, board.createdDate);
                }
            }
        }
        return null;
    }


    private BooleanExpression usernameEq(String username){
        return !isEmpty(username) ? member.username.contains(username) : null;
    }
    private BooleanExpression titleEq(String title){
        return !isEmpty(title) ? board.title.contains(title) : null;
    }
    private BooleanExpression usernameOrTitleEq(String all){
        return !isEmpty(all) ? board.title.contains(all).or(member.username.contains(all)) : null;
    }
}
