package com.coffeepot.coffeepotspring.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Memo")
public class MemoEntity {

	@Id
	@UuidGenerator
	private String id;

	private Boolean visibility;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@ManyToOne
	private UserEntity author;

	// 다대다 관계는 명시적 테이블 생성
	// users - scrap - memos
	// users - like - memos
	@Builder.Default
	@OneToMany(mappedBy = "memoEntity")
	private List<UserScrapMemo> scrapers = new ArrayList<>();

	@Builder.Default
	@OneToMany(mappedBy = "memoEntity")
	private List<UserLikeMemo> likers = new ArrayList<>();

}
