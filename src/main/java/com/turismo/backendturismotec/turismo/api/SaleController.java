package com.turismo.backendturismotec.turismo.api;

import com.turismo.backendturismotec.turismo.domain.service.SaleService;
import com.turismo.backendturismotec.turismo.mapping.SalesMapper;
import com.turismo.backendturismotec.turismo.resources.sales.CreateSalesResources;
import com.turismo.backendturismotec.turismo.resources.sales.SalesResources;
import com.turismo.backendturismotec.turismo.resources.sales.UpdateSalesResources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sales")
public class SaleController {
    private final SaleService saleService;
    private final SalesMapper mapper;

    public SaleController(SaleService saleService, SalesMapper mapper){
        this.saleService = saleService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SalesResources> getAllSales(Pageable pageable) {
        return mapper.modelListPage(saleService.getAll(), pageable);
    }

    @GetMapping("{saleId}")
    public SalesResources getSalesById(@PathVariable Long saleId){
        return mapper.toResource(saleService.getById(saleId));
    }

    @PostMapping
    public SalesResources createSales(@RequestBody CreateSalesResources resource){
        return mapper.toResource(saleService.create(mapper.toModel(resource)));
    }

    @PutMapping("{saleId}")
    public SalesResources updateSales(@PathVariable Long saleId,
                                          @RequestBody UpdateSalesResources resource){
        return mapper.toResource(saleService.update(saleId, mapper.toModel(resource)));
    }

    @DeleteMapping("{saleId}")
    public ResponseEntity<?> deleteSales(@PathVariable Long saleId){
        return saleService.delete(saleId);
    }
}
