package com.tybms.material.api;

import com.tybms.material.dto.MaterialCreateRequest;
import com.tybms.material.dto.MaterialResponse;
import com.tybms.material.entity.Material;
import com.tybms.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/materials")
public class MaterialApiController {

    private final MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> findAll() {
        List<MaterialResponse> materialResponses = materialService.findAll();
        return ResponseEntity.ok(materialResponses);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = materialService.save(materialCreateRequest);
        return ResponseEntity.created(URI.create("/" + savedMaterial.getId())).build();
    }

//    조회수 증가 기능 고민좀 해보자.,.. id랑 조회수받아서 save?
//    @PatchMapping("/{id}")
//    public ResponseEntity<Long> increaseViewCount(@PathVariable Long id) {
//    }

}
