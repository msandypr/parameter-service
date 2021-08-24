package b2camp.timc.parameterservice.service;

import b2camp.timc.parameterservice.dtos.request.MSavingProductRequest;
import b2camp.timc.parameterservice.dtos.response.MSavingProductResponse;
import b2camp.timc.parameterservice.models.MSavingProduct;

public interface MSavingProductService {
    Iterable<MSavingProduct> getAllSavingProduct();

    MSavingProduct getSavingProductById(Long id);

    MSavingProductResponse createMSProduct(MSavingProductRequest savingProductRequest);

    MSavingProductResponse updateProductName(Long id, MSavingProductRequest savingProductRequest);

    void deleteMSavingProductById(Long id);
}
