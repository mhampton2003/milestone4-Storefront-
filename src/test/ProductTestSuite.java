package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   ArmorTest.class ,WeaponTest.class ,HealthTest.class ,ProductTest.class
})

public class ProductTestSuite {
}