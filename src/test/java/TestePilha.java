import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePilha {

    private Pilha p;

    @Before
    public void inicializarPilha(){
        p = new Pilha(10);
    }

    @Test
    public void pilhaVazia(){
        assertTrue(p.estaVazia());
        assertEquals(0,p.tamanho());
    }

    @Test
    public void empilhaUmElemento(){
        p.empilha("primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro",p.topo());
    }

    @Test
    public void empilhaSegundoElemento(){
        p.empilha("primeiro");
        p.empilha("segundo");
        assertEquals(2, p.tamanho());
        assertEquals("segundo",p.topo());
    }

    @Test
    public void empilhaDesempilha(){
        p.empilha("primeiro");
        p.empilha("segundo");
        assertEquals(2, p.tamanho());
        assertEquals("segundo",p.topo());
        Object desempilhado = p.desempilha();
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
        assertEquals("segundo", desempilhado);
    }

    @Test(expected = PilhaVaziaException.class)
    public void removePilhaVazia(){
        p.desempilha();
    }

    @Test(expected = PilhaCheiaException.class)
    public void adicionaPilhaCheia(){
        for (int i = 0; i < 10; i++){
            p.empilha("elemento"+i);
        }
        try {
            p.empilha("boom");
            fail();
        }catch (PilhaCheiaException e){}
    }
}
