package com.tybms.material.api;

import com.tybms.material.dto.MaterialCreateRequest;
import com.tybms.material.dto.MaterialResponse;
import com.tybms.material.dto.MaterialUpdateRequest;
import com.tybms.material.entity.Material;
import com.tybms.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/materials")
public class MaterialApiController {

    private final MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> findAll() {
        List<MaterialResponse> materialResponses = this.materialService.findAll();
        return ResponseEntity.ok(materialResponses);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = this.materialService.save(materialCreateRequest);
        return ResponseEntity.created(URI.create("/" + savedMaterial.getId())).build();
    }

    @PatchMapping
    public ResponseEntity<Void> increaseViewCount(@RequestBody Map<Long, Long> viewCountToIds) {
        this.materialService.increaseViewCount(viewCountToIds);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MaterialUpdateRequest materialUpdateRequest) {
        this.materialService.update(materialUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.materialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
