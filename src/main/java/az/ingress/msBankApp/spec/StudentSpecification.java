package az.ingress.msBankApp.spec;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.enums.SearchOperation;
import az.ingress.msBankApp.model.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

//@Builder
//@AllArgsConstructor
//@RequiredArgsConstructor
public class StudentSpecification implements Specification<Student> {

    private final List<SearchCriteria> searchCriteriaList;

    public StudentSpecification() {
        this.searchCriteriaList = new ArrayList<>();

    }

    public void addSearchCriteria(SearchCriteria searchCriteria) {
        searchCriteriaList.add(searchCriteria);
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : searchCriteriaList) {
            if (criteria.getSearchOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.LESS_THAN)){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.GREATER_THAN_EQUAL)){
                predicates.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.LESS_THAN_EQUAL)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.NOT_EQUAL)){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.EQUAL)){
                predicates.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.CONTAINS)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.DOES_NOT_CONTAIN)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.ALL)){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.ANY)){
                predicates.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.NOT_NULL)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.NULL)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.DOES_NOT_BEGIN_WITH)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.DOES_NOT_END_WITH)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getSearchOperation().equals(SearchOperation.ENDS_WITH)){
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
