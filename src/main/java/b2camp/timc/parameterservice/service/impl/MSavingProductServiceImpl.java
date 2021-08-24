package b2camp.timc.parameterservice.service.impl;

import b2camp.timc.parameterservice.dtos.request.MSavingProductRequest;
import b2camp.timc.parameterservice.dtos.response.MSavingProductResponse;
import b2camp.timc.parameterservice.models.MSavingProduct;
import b2camp.timc.parameterservice.repositories.MSavingProductRepo;
import b2camp.timc.parameterservice.service.MSavingProductService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class MSavingProductServiceImpl implements MSavingProductService {

    private final MSavingProductRepo mSavingProductRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    @Transactional

    public Iterable<MSavingProduct> getAllSavingProduct() {
        return mSavingProductRepo.findAll();
    }

    @Transactional
    @SneakyThrows
    @Override
    public MSavingProduct getSavingProductById(Long id) {
        entityManager = emf.createEntityManager();
        log.info("Find City based on City Id"+id);
        return entityManager.find(MSavingProduct.class,id);
    }

    @Transactional
    @Override
    public MSavingProductResponse createMSProduct(MSavingProductRequest savingProductRequest) {
        MSavingProduct saveDataMSavingProduct = MSavingProduct.builder()
                .productName(savingProductRequest.getProductName())
                .description(savingProductRequest.getDescription())
                .deleted(Boolean.FALSE)
                .build();

        MSavingProduct savingProduct = mSavingProductRepo.save(saveDataMSavingProduct);

        MSavingProductResponse getResponseMSaving = MSavingProductResponse.builder()
                .id(savingProduct.getId())
                .productName(savingProduct.getProductName())
                .description(savingProduct.getDescription())
                .build();

        return getResponseMSaving;
    }

    @Override
    @Transactional
    @SneakyThrows
    public MSavingProductResponse updateProductName(Long id, MSavingProductRequest savingProductRequest) {
        Optional<MSavingProduct> findProduct = mSavingProductRepo.findById(id);
        if (findProduct == null){
            throw new Exception("Product with" + id + "Not Found");
        }
        findProduct.get().setProductName(savingProductRequest.getProductName());
        findProduct.get().setDescription(savingProductRequest.getDescription());

        MSavingProduct mSavingProduct = mSavingProductRepo.save(findProduct.get());
        return MSavingProductResponse.builder()
                .id(mSavingProduct.getId())
                .productName(mSavingProduct.getProductName())
                .description(mSavingProduct.getDescription())
                .build();
    }

    @Transactional
    @Override
    @SneakyThrows
    public void deleteMSavingProductById(Long id) {
            var cek = mSavingProductRepo.findById(id).get();
            cek.setDeleted(Boolean.TRUE);
    }
}
