import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuunamataGraafTest {
    private SuunamataGraaf g1a = new SuunamataGraaf(
            "graph {\n" +
                    "    a -- b -- c;\n" +
                    "    b -- d;\n" +
                    "}"
    );

    private SuunamataGraaf g1b = new SuunamataGraaf(
            "graph {\n" +
                    "    a -- b;\n" +
                    "    b -- c;\n" +
                    "    b -- d;\n" +
                    "}"
    );

    private SuunamataGraaf g1c = new SuunamataGraaf(
            "graph {\n" +
                    "    b -- c;\n" +
                    "    a -- b;\n" +
                    "    b -- d;\n" +
                    "}"
    );

    private SuunamataGraaf g1d = new SuunamataGraaf(
            "graph {\n" +
                    "    c -- b;\n" +
                    "    a -- b;\n" +
                    "    d -- b;\n" +
                    "}"
    );
    private SuunamataGraaf g1e = new SuunamataGraaf(
            "graph {a -- b -- c; d -- b}"
    );

    private SuunamataGraaf g2 = new SuunamataGraaf(
            "graph {\n" +
                    "    c -- b;\n" +
                    "    d -- b;\n" +
                    "}"
    );

    private SuunamataGraaf g8 = new SuunamataGraaf(
            "graph {\n" +
                    "  a -- b -- c;\n" +
                    "  b -- d;\n" +
                    "  r;\n" +
                    "  w -- w;\n" +
                    "  ka -- pa;\n" +
                    "}"
    );

    @Test
    public void t01_tipuAsteJaNaabrid() {
        assertEquals(1, g1a.tipuAste("a"));
        assertEquals(3, g1a.tipuAste("b"));
        assertEquals(1, g1a.tipuAste("c"));
        assertEquals(1, g1a.tipuAste("d"));

        assertEquals(new HashSet<>(Arrays.asList("b")),
                g1a.tipuNaabrid("a"));
        assertEquals(new HashSet<>(Arrays.asList("a", "c", "d")),
                g1a.tipuNaabrid("b"));
        assertEquals(new HashSet<>(Arrays.asList("b")),
                g1a.tipuNaabrid("c"));
        assertEquals(new HashSet<>(Arrays.asList("b")),
                g1a.tipuNaabrid("d"));

        assertEquals(new HashSet<>(),
                g8.tipuNaabrid("r"));
        assertEquals(new HashSet<>(Arrays.asList("w")),
                g8.tipuNaabrid("w"));
        assertEquals(new HashSet<>(Arrays.asList("pa")),
                g8.tipuNaabrid("ka"));
        assertEquals(new HashSet<>(Arrays.asList("ka")),
                g8.tipuNaabrid("pa"));
    }

    @Test
    public void t02_equals() {
        assertEquals(g1a, g1b);
        assertEquals(g1b, g1c);
        assertEquals(g1c, g1d);
        assertEquals(g1d, g1a);
        assertEquals(g1a, g1d);
        assertEquals(g1c, g1e);

        assertNotEquals(g1c, g2);
        assertNotEquals(g1c, g8);
    }

    @Test
    public void t03_onAlamgraaf() {
        assertTrue(g2.onAlamgraaf(g1a));
        assertTrue(g1a.onAlamgraaf(g8));
        assertFalse(g1a.onAlamgraaf(g2));

        // graaf on iseenda alamgraaf
        assertTrue(g1a.onAlamgraaf(g1a));
        assertTrue(g2.onAlamgraaf(g2));
    }

    @Test
    public void t04_toString() {
        assertEquals(g1a, new SuunamataGraaf(g1a.toString()));
        assertEquals(g1b, new SuunamataGraaf(g1b.toString()));
        assertEquals(g1c, new SuunamataGraaf(g1c.toString()));
        assertEquals(g2, new SuunamataGraaf(g2.toString()));
    }

    @Test
    public void t05_suuremGraaf() throws Exception {
        SuunamataGraaf g3a = new SuunamataGraaf(
                "graph {\n" +
                        "  Tartu -- Paide -- Tallinn;Valga--Tartu -- Elva;\n" +
                        "\n" +
                        "  Kuressaare -- Kuivastu -- \n" +
                        "\n" +
                        "\n" +
                        "Parnu --Viljandi -- Tartu;\n" +
                        "  Tallinn -- Parnu;\n" +
                        "}"
        );

        SuunamataGraaf g3Failist = new SuunamataGraaf(new File("graaf.txt"));

        SuunamataGraaf g3b = new SuunamataGraaf("graph {\n" +
                "  Elva -- Tartu;\n" +
                "  Kuivastu -- Kuressaare;\n" +
                "  Kuivastu -- Parnu;\n" +
                "  Paide -- Tallinn;\n" +
                "  Paide -- Tartu;\n" +
                "  Parnu -- Tallinn;\n" +
                "  Parnu -- Viljandi;\n" +
                "  Tartu -- Valga;\n" +
                "  Tartu -- Viljandi;\n" +
                "}");

        assertEquals(g3a, g3Failist);
        assertEquals(g3b, g3a);

        assertEquals(new HashSet<>(Arrays.asList("Viljandi", "Valga", "Paide", "Elva")),
                g3a.tipuNaabrid("Tartu"));
        assertEquals(new HashSet<>(Arrays.asList("Kuivastu")),
                g3a.tipuNaabrid("Kuressaare"));
        assertEquals(new HashSet<>(Arrays.asList("Kuressaare", "Parnu")),
                g3a.tipuNaabrid("Kuivastu"));
    }

}