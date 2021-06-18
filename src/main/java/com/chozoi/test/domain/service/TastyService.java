package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.TastyDTO;
import com.chozoi.test.domain.entities.Category;
import com.chozoi.test.domain.entities.Tasty;
import com.chozoi.test.domain.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class TastyService extends BaseService{
    public ResponseEntity<?> findByTasty(String name){
        List<Tasty> tasty = tastyRepository.findByName(name);
        List<TastyDTO> dtos = convertListTastyToDTOs(tasty);
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<?> findByIdCate(int id){
        List<Tasty> tasty = tastyRepository.findAllByCategoryId(id);
        List<TastyDTO> dtos = convertListTastyToDTOs(tasty);
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<?> getAllTasty(){
        List<Tasty> tasty = tastyRepository.findAll();
        List<TastyDTO> dtos = convertListTastyToDTOs(tasty);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private Category initCategory(int categoryId){
        Category category = new Category();
        category.setId(categoryId);
        return category;
    }

    public ResponseEntity<?> addTasty(TastyDTO tastyDTO){
        if (Objects.nonNull(tastyDTO)) {
            Tasty tasty = Tasty.builder()
                    .name(tastyDTO.getName())
                    .price(tastyDTO.getPrice())
                    .des(tastyDTO.getDes())
                    .quantities(tastyDTO.getQuantities())
                    .category(initCategory(tastyDTO.getCategory_id()))
                    .build();
            tastyRepository.save(tasty);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    public ResponseEntity<?> deleteTasty(int tastyId){
        Tasty tasty = tastyRepository.findById(tastyId).orElse(null);
        if (Objects.nonNull(tasty)){
            tastyRepository.delete(tasty);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateTasty(TastyDTO tastyDTO, int id){
        Tasty update = getTastyById(id);
        if (Objects.nonNull(update)) {
            update.setDes(tastyDTO.getDes());
            update.setName(tastyDTO.getName());
            update.setPrice(tastyDTO.getPrice());
            update.setQuantities(tastyDTO.getQuantities());
            update.setCategory(initCategory(tastyDTO.getCategory_id()));
            tastyRepository.saveAndFlush(update);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    private Tasty getTastyById(int id){
        return tastyRepository.findById(id).orElse(null);
    }
}
