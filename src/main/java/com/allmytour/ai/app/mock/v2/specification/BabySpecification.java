package com.allmytour.ai.app.mock.v2.specification;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import org.springframework.data.jpa.domain.Specification;

public class BabySpecification {
    public static Specification<Baby> hasName(String name) {
        return (root, query, criteriaBuilder) -> name != null ? criteriaBuilder.equal(root.get("name"), name) : null;
    }

    public static Specification<Baby> hasFatherName(String fatherName) {
        return (root, query, criteriaBuilder) -> fatherName != null ? criteriaBuilder.equal(root.join("father").get("name"), fatherName) : null;
    }
    public static Specification<Baby> hasMotherName(String motherName) {
        return (root, query, criteriaBuilder) -> motherName != null ? criteriaBuilder.equal(root.join("mother").get("name"), motherName) : null;
    }
}
