package simvita.core;

import sofia.graphics.Color;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Test cases for the Creature class.
 *
 *  @author verro ejiba
 *  @version Dec 6, 2012
 */
public class CreatureTest extends student.TestCase
{
    private Creature creature;
    private Position p;
    private String name;
    private Description desc;
    private int frequency;
    private ArrayList<StatusEffect<Creature>> effect;
    private Creature creature2;

    public void setUp()
    {
        creature = new Creature(p, name, desc, Color.red, frequency);
        creature2 = new Creature(p, name, desc, Color.gray, effect);

        //thing = new Thing();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testAddStatusEfffect()
    {
        creature.addStatusEffect(null);
        assertNull(effect);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testRemoveStatusEffect()
    {
        StatusEffect<Creature> s = null;
        creature.addStatusEffect(s);
        creature.removeStatusEffect(s);
       assertNull(effect);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testClearStatusEffect()
    {
        StatusEffect<Creature> s = null;
        creature.addStatusEffect(s);
        creature.clearStatusEffects();
        assertNull(effect);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testHasStatusEffect()
    {

        StatusEffect<Creature> s = null;
        creature.addStatusEffect(s);
        assertEquals(true, creature.hasStatusEffect(s));
        creature.removeStatusEffect(s);
        assertEquals(false, creature.hasStatusEffect(s));
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetStatusEffects()
    {
        StatusEffect<Creature> s = null;
        creature.addStatusEffect(s);
        assertEquals(effect, creature.getStatusEffects());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testActGetFrequency()
    {
        //creature.setActfrequency(5);
        this.frequency = 5;
        assertEquals(frequency, creature.getActFrequency());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testIsDead()
    {
        assertEquals(false, creature.isDead());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testKill()
    {
        creature.isDead();
        creature.kill();
        assertNull(null);
    }
}
