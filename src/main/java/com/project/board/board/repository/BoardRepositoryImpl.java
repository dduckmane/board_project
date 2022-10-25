package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import com.project.board.board.domain.QBoard;
import com.project.board.member.domain.QMember;
import com.project.board.reply.domain.QReply;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

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
    public Page<Board> searchForUsername(String username, Pageable pageable) {
        List<Board> result = queryFactory
                .select(board).distinct()
                .from(board)
                .join(board.member,member).fetchJoin()
                .join(board.replies,reply)
                .where(usernameEq(username))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(board.count())
                .from(board)
                .join(board.member,member)
                .join(board.replies,reply)
                .where(usernameEq(username));
        return PageableExecutionUtils.getPage(result,pageable,CountQuery::fetchOne);
    }

    @Override
    public Page<Board> searchByTitle(String title, Pageable pageable) {

        List<Board> result = queryFactory
                .select(board).distinct()
                .from(board)
                .join(board.member,member).fetchJoin()
                .join(board.replies,reply)
                .where(titleEq(title))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(board.count()).distinct()
                .from(board)
                .join(board.member,member)
                .join(board.replies,reply)
                .where(titleEq(title));
        return PageableExecutionUtils.getPage(result,pageable,CountQuery::fetchOne);
    }

    @Override
    public Page<Board> searchByUsernameAndTitle(String text, Pageable pageable) {
        List<Board> result = queryFactory
                .select(board).distinct()
                .from(board)
                .join(board.member,member).fetchJoin()
                .join(board.replies,reply)
                .where(usernameOrTitleEq(text))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(board.count()).distinct()
                .from(board)
                .join(board.member,member)
                .join(board.replies,reply)
                .where(usernameOrTitleEq(text));
        return PageableExecutionUtils.getPage(result,pageable,CountQuery::fetchOne);
    }

    @Override
    public Page<Board> searchAll(Pageable pageable) {
        List<Board> result = queryFactory
                .select(board).distinct()
                .from(board)
                .join(board.member,member).fetchJoin()
                .join(board.replies,reply)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(board.count())
                .from(board);
        return PageableExecutionUtils.getPage(result,pageable,CountQuery::fetchOne);
    }

    private BooleanExpression usernameEq(String username){
        return hasText(username) ? member.username.contains(username) : null;
    }
    private BooleanExpression titleEq(String title){
        return hasText(title) ? board.title.contains(title) : null;
    }
    private BooleanExpression usernameOrTitleEq(String text){
        return hasText(text) ? board.title.contains(text).or(member.username.contains(text)) : null;
    }
}
