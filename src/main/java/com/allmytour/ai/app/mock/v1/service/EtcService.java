package com.allmytour.ai.app.mock.v1.service;

import com.allmytour.ai.app.mock.v1.domain.Child;
import com.allmytour.ai.app.mock.v1.domain.GrandParent;
import com.allmytour.ai.app.mock.v1.domain.Parent;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;
import com.allmytour.ai.app.mock.v1.repository.ChildRepository;
import com.allmytour.ai.app.mock.v1.repository.GrandChildRepository;
import com.allmytour.ai.app.mock.v1.repository.GrandParentRepository;
import com.allmytour.ai.app.mock.v1.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtcService {

    private final GrandParentRepository grandParentRepository;
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final GrandChildRepository grandChildRepository;

    @Transactional
    public GrandParent makeGrandParent(String num) {
        GrandParent grandParent = new GrandParent();
        grandParent.setName("grandParent"+num);
        grandParentRepository.save(grandParent);
        return grandParent;
    }
    @Transactional
    public void randomMakeParent(String num){

        GrandParent grandParent = grandParentRepository.getRandomGrandParent();

        List<Parent> parents = new ArrayList<>();
        for (int i = 1 ; i< 3 ; i++ ) {
            Parent parent = new Parent();
            parent.setName("parent"+num+"_"+i);
            parent.setGrandParent( grandParent );
            parentRepository.save( parent );
        }

    }
    @Transactional
    public GrandParent makeGrandParentParent(String num ) {
        GrandParent grandParent = new GrandParent();
        grandParent.setName("grandParent"+num);

        List<Parent> parents = new ArrayList<>();
        grandParent.setParents(parents);
        for (int i = 1 ; i< 3 ; i++ ) {
            Parent parent = new Parent();
            parent.setName("parent"+num+"_"+i);
            parent.setGrandParent( grandParent );
            parents.add(parent);
//            parentRepository.save( parent );
        }

        grandParentRepository.save(grandParent);

        return grandParent;


    }
    @Transactional
    public List<Parent> findParentsByCriteria(SearchCriteria searchCriteria) {
        return parentRepository.findParentsByCriteria(searchCriteria);
    }
    @Transactional
    public List<Child> findChildByCriteria(SearchCriteria searchCriteria) {
        return childRepository.findChildByCriteria(searchCriteria);
    }

    @Transactional
    public void makeChild(){

    }
    @Transactional
    public void makeGrandChild(){

    }
    @Transactional
    public void makeFamily(){

    }
    @Transactional
    public void getGrandParent(Long id){
        grandParentRepository.getGrandParent(id);

    }

}
