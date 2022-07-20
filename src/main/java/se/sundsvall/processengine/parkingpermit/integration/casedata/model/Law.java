package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Law {

    // Rubrik
    private String heading;
    // Svensk författningssamling, (SFS)
    private String sfs;
    // kapitel
    private String chapter;
    // paragraf
    private String article;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Law)) return false;
        Law law = (Law) o;
        return Objects.equals(heading, law.heading) && Objects.equals(sfs, law.sfs) && Objects.equals(chapter, law.chapter) && Objects.equals(article, law.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, sfs, chapter, article);
    }
}
