package com.toanng.dataemcommerceapi.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "reviews", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewEntity {

    @EmbeddedId
    ReviewPKId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    OrderEntity order;

    @Column(name = "review_score")
    Integer reviewScore;

    @Column(name = "review_comment_title")
    String reviewCommentTitle;

    @Column(name = "review_comment_message")
    String reviewCommentMessage;

    @Column(name = "review_creation_date")
    Instant reviewCreationDate;

    @Column(name = "review_answer_timestamp")
    Instant reviewAnswerTimestamp;

}
