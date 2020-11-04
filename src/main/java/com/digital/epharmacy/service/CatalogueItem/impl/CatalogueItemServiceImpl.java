package com.digital.epharmacy.service.CatalogueItem.impl;

/*
 * Author: Nelson Mpyana
 * Desc: CatalogueItemServiceImpl
 * Date: 3 September 2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
//import com.digital.epharmacy.repository.CatalogueItem.Impl.CatalogueItemRepositoryImpl;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatalogueItemServiceImpl implements CatalogueItemService {
    private static final int PAGE_ELEMENT_SIZE_ADMIN=12;
    private static final int PAGE_ELEMENT_SIZE_CUSTOMER=12;
    private static CatalogueItemService service = null;


    @Autowired
    private CatalogueItemRepository repository;

    @Override @Transactional
    public Set<CatalogueItem> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public List<CatalogueItem> findAllItemsByProductCategory(String productCategory){
        Set<CatalogueItem> orders = getAll();
        List <CatalogueItem> itemsByCategory;

        itemsByCategory = orders.stream()
                .filter(o -> o .getItemDescription()
                .trim()
                .equalsIgnoreCase(productCategory))
                .collect(Collectors.toList());
        return itemsByCategory;
    }

    @Override @Transactional
    public CatalogueItem create(CatalogueItem catalogueItem) {
        return this.repository.save(catalogueItem);
    }

    @Override @Transactional
    public CatalogueItem read(String catalogueItem) {
        return this.repository.findById(catalogueItem).orElse(null);
    }



    @Override @Transactional
    public CatalogueItem update(CatalogueItem catalogueItem) {
        return this.repository.save(catalogueItem);
    }


    @Override @Transactional
    public boolean delete(String catalogueItem) {
        this.repository.deleteById(catalogueItem);
        if (!this.repository.existsById(catalogueItem)) return true;
        return false;
    }



}
