package com.cashmanagerbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "expense_categories")
public class ExpenseCategory extends BaseEntity{
    @Column(name = "title", nullable = false, length = 50)
    @Size(min = 2,max = 50, message = "Title must be between 2 and 50")
    @NotBlank(message = "Title can't be blank")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_expense_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new LinkedHashSet<>();

}