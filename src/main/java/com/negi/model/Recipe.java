package com.negi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Recipe {
	@Id
	@SequenceGenerator(name = "reipe_sequence", sequenceName = "recipe_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_sequence")
	private Long id;

	@NotBlank
	private String title;

	@ManyToOne
	private User user;

	private String image;

	private String description;

	private String category;

	private LocalDateTime createdAt;

	@Lob
	private String instructions;

	@ElementCollection
	private List<String> ingredients = new ArrayList<>();

	@ElementCollection
	private List<Long> likes = new ArrayList<>();
}