package com.turismo.turismoapi.turismo.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sales")
public class SaleController {
    private final SalesService saleService;
    private final SalesMapper mapper;

    public SaleController(SalesService saleService, SalesMapper mapper){
        this.saleService = saleService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SalesResource> getAllSales(Pageable pageable) {
        return mapper.modelListPage(saleService.getAll(), pageable);
    }

    @GetMapping("{saleId}")
    public SalesResource getSalesById(@PathVariable Long saleId){
        return mapper.toResource(saleService.getById(saleId));
    }

    @PostMapping
    public SalesResource createSales(@RequestBody CreateSalesResource resource){
        return mapper.toResource(saleService.create(mapper.toModel(resource)));
    }

    @PutMapping("{saleId}")
    public SalesResource updateSales(@PathVariable Long saleId,
                                          @RequestBody UpdateSalesResource resource){
        return mapper.toResource(saleService.update(saleId, mapper.toModel(resource)));
    }

    @DeleteMapping("{saleId}")
    public ResponseEntity<?> deleteSales(@PathVariable Long saleId){
        return saleService.delete(saleId);
    }
}
