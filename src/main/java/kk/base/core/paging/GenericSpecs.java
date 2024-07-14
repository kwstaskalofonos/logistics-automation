package kk.base.core.paging;

import jakarta.persistence.criteria.Predicate;
import kk.base.core.entity.Company;
import kk.base.core.enumeration.FieldType;
import kk.base.core.utils.Utils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class GenericSpecs<E> {


    public Specification<E> areFieldsLike(FiltersDto filters, Company company) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("company"),company));
            for (FieldValueDto field : filters.getFields()) {
                if (!Utils.isEmpty(field.getType()) && field.getType() == FieldType.NUMBER) {
                    predicates.add(criteriaBuilder.equal(root.get(field.getFieldName()), field.getValue()));
                } else {
                    predicates.add(criteriaBuilder.like(root.get(field.getFieldName()), "%" + field.getValue() + "%"));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
