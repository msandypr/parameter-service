package b2camp.timc.parameterservice.controllers;

import b2camp.timc.parameterservice.dtos.request.MSavingProductRequest;
import b2camp.timc.parameterservice.dtos.response.MSavingProductResponse;
import b2camp.timc.parameterservice.models.MSavingProduct;
import b2camp.timc.parameterservice.service.MSavingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msavingproduct")
public class MSavingProductController {

    @Autowired
    MSavingProductService mSavingProductService;

    @PostMapping
    public MSavingProductResponse add(@RequestBody MSavingProductRequest mSavingProductRequest) {
        return mSavingProductService.createMSProduct(mSavingProductRequest);
    }

    @PutMapping(value = "/{id}")
    public MSavingProductResponse update(@PathVariable(value = "id") Long id, @RequestBody MSavingProductRequest mSavingProductRequest) {
        return mSavingProductService.updateProductName(id, mSavingProductRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable("id") Long id) {
        mSavingProductService.deleteMSavingProductById(id);
        return "sukses merubah value is_Delete menjadi true";
    }

    @GetMapping
    public Iterable<MSavingProduct> findAll() {
        return mSavingProductService.getAllSavingProduct();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MSavingProduct findProductId(@PathVariable Long id) {
        return mSavingProductService.getSavingProductById(id);


    }
}
