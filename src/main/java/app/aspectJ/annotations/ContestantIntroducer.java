package app.aspectJ.annotations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents(
            value = "app.aspectJ.annotations.Performer+",
            defaultImpl = GraciousContestant.class
    )
    public static Contestant contestant;
}
