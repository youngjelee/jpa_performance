package com.allmytour.ai.app.mock;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDateTime sentDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;
}