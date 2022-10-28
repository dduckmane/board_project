package com.project.board.reply.repository;

import com.project.board.board.domain.QBoard;
import com.project.board.member.domain.QMember;
import com.project.board.reply.domain.QReply;
import com.project.board.reply.domain.Reply;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static com.project.board.board.domain.QBoard.*;
import static com.project.board.member.domain.QMember.*;
import static com.project.board.reply.domain.QReply.*;

public class ReplyRepositoryImpl implements ReplyRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public ReplyRepositoryImpl(EntityManager em) {
        this.queryFactory=new JPAQueryFactory(em);
    }

    @Override
    public Page<Reply> searchAll(Long boardId,Pageable pageable) {
        List<Reply> results = queryFactory
                .selectFrom(reply)
                .leftJoin(reply.board, board).fetchJoin()
                .leftJoin(reply.member, member).fetchJoin()
                .where(board.id.eq(boardId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> CountQuery = queryFactory
                .select(reply.count())
                .from(reply);
        return PageableExecutionUtils.getPage(results,pageable,CountQuery::fetchOne);
    }
}
