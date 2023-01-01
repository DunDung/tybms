package co.kr.tybms.material.entity;

import co.kr.tybms.config.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Entity
@Audited
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MaterialAttachedFile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_ID")
    private Material material;

    public void setMaterial(Material material) {
        this.material = material;
    }
}