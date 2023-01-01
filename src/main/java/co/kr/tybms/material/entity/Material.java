package co.kr.tybms.material.entity;

import co.kr.tybms.config.BaseEntity;
import co.kr.tybms.material.dto.MaterialUpdateRequest;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@Audited
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Material extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;

    @Lob
    @Column
    private String content;

    @ColumnDefault("0")
    private Long viewCount;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MaterialAttachedFile> materialAttachedFiles;

    public List<String> getMaterialAttachedFileNames() {
        return this.materialAttachedFiles.stream()
                .map(MaterialAttachedFile::getName)
                .collect(Collectors.toList());
    }

    public Material update(MaterialUpdateRequest materialUpdateRequest) {
        this.title = materialUpdateRequest.getTitle();
        this.content = materialUpdateRequest.getContent();
        return this;
    }
}