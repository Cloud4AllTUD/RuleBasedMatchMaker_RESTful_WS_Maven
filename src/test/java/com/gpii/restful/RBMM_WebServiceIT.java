package com.gpii.restful;

import com.gpii.jsonld.JsonLDManager;
import com.gpii.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import junit.framework.TestCase;

public class RBMM_WebServiceIT extends TestCase {
  public void test_() {

    if (JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS) {
      // Core test cases
      _ComPref();
      _AppPref();
      _DetectNoSolConflict();
      _ResNoSolutionConflict_InputRange();
      _ResNoSolutionConflict_SimpleInput();
      _ResMSCuserPriority();
      _ResMSCuserPriorities();
      /*// Pilots 3 test cases
      _MMTest1a();
      _MMTest1b();
      _MMTest1c();
      //_MMTest1d();
      _MMTest2();
      _MMTest3();
      _MMTest4a();
      _MMTest4b();
      _MMTest4c();
      _MMTest5a();
      _MMTest5b();
      _MMTest6a();
      _MMTest6b();
      // Review 4 test cases
      _Alicia();
      //_CombinedScenario1();
      //_CombinedScenario2();
      _AliciaSz2();
      _LiaAndManuel();*/

    } else
      System.out
          .println("INTEGRATION TESTS WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");

  }
  private void _ComPref() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing Core Matching Rules for 'Common Prerfs' *****");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/ComPref.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/ComPrefOUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_ComPref");
  }
  private void _AppPref() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'App-specific Prerfs' ***********************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/AppPref.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/AppPrefOUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_AppPref");
  }
  private void _DetectNoSolConflict() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'Required Preference is NOT suported by *****");
    System.out.println("* installed solutions. Assert NoSulutionConflict ******");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/DetectNoSolConflict.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/DetectNoSolConflictOUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_DetectNoSolConflict");
  }
  private void _ResNoSolutionConflict_InputRange() {
    System.out.println("\n**********************************************************");
    System.out.println("* Test: 'NoSolutionConflict_InputRange' ********************");
    System.out.println("* Approach: preference subsitutes **************************");
    System.out.println("* Scope: 'magnification' Substitute: 'screen resolution' ***");
    System.out.println("************************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/ResNoSolConflict1.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/ResNoSolConflict1OUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_ResNoSolutionConflict_InputRange");
  }
  private void _ResNoSolutionConflict_SimpleInput() {
    System.out.println("\n**********************************************************");
    System.out.println("* Test: 'NoSolutionConflict_SimpleInput' ********************");
    System.out.println("* Approach: preference subsitutes **************************");
    System.out.println("* Scope: 'magnification' Substitute: 'screen resolution' ***");
    System.out.println("************************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/ResNoSolConflict2.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/ResNoSolConflict2OUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_ResNoSolutionConflict_SimpleInput");
  }  
  public void _ResMSCuserPriority()
  {
      System.out.println("\n****************** ResMSCuserPriority ******************************");
      System.out.println("** Multiple ATs of the same type are locally installed *****************");
      System.out.println("** and the user has indicated exactely one product priority of  ********");
      System.out.println("** and the prioritized product is amongst the installed ****************");      
      System.out.println("\n**********************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/ResMSCuserPriority.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/ResMSCuserPriorityOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_ResMSCuserPriority");           
  }
  public void _ResMSCuserPriorities()
  {
      System.out.println("\n****************** ResMSCuserPriorities ******************************");
      System.out.println("** Multiple ATs of the same type are locally installed *****************");
      System.out.println("** and the user has indicated a product priority of  *******************");
      System.out.println("** and the prioritized product is amongst the installed ****************");      
      System.out.println("\n**********************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/ResMSCuserPriorities.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/ResMSCuserPrioritiesOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_ResMSCuserPriorities");           
  }    
  public void _MMTest1a()
  {
      System.out.println("\n******************_MMTest1a ******************************************");
      System.out.println("** Multiple ATs of the same type are locally installed *****************");
      System.out.println("** and the user has not indicated which AT is preferred. ***************");     
      System.out.println("** Resolution based on a expert defined ranking of AT ** ***************");
      System.out.println("** defined in knowledge set rankingOfATs *******************************");        
      System.out.println("\n**********************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1a.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1aOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_MMTest1a");           
  }
  public void _MMTest1b()
  {
      System.out.println("\n******************_MMTest1b **************************************************");
      System.out.println("** Multiple ATs of the same type are available, either locally or as ***********");
      System.out.println("** cloud-based solution. The user has not indicated which AT is preferred. *****");     
      System.out.println("** Resolution based on the application layer of a solution (os, browser, cloud)*");
      System.out.println("** OS ATs are prioritized over browser solutions *******************************");        
      System.out.println("\n******************************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1b.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1bOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_MMTest1b");           
  }
  public void _MMTest1c()
  {
      System.out.println("\n******************_MMTest1c **********************************************");
      System.out.println("** Multiple ATs of the same type and sharing functionalities ***************");
      System.out.println("** cloud-based solution. The user has not indicated which AT is preferred. *");     
      System.out.println("** Resolution based on a expert defined ranking of AT ** *******************");
      System.out.println("** defined in knowledge set rankingOfATs ***********************************");        
      System.out.println("\n**************************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1c.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1cOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_MMTest1c");           
  }  
  public void _MMTest1d()
  {
      System.out.println("\n******************_MMTest1d **********************************************");
      System.out.println("** Multiple ATs and suits of the same type.**************** ****************");
      System.out.println("** The user has not indicated which AT is preferred. ***********************");     
      System.out.println("** Resolution based on a expert defined ranking of AT ** *******************");
      System.out.println("** defined in knowledge set rankingOfATs ***********************************");        
      System.out.println("\n**************************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1d.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1dOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_MMTest1d");           
  }
  public void _MMTest2()
  {
      System.out.println("\n******************_MMTest2 ***********************************************");
      System.out.println("** Multiple ATs of the same class locally available but the preferred ******");
      System.out.println("** sulotion is missing. ****************************************************");     
      System.out.println("** Resolution based on a expert defined ranking of AT ** *******************");
      System.out.println("** defined in knowledge set rankingOfATs ***********************************");        
      System.out.println("\n**************************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest2.json";
      String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest2OUT.json";
      
      performTest(filepathIN, filepathExpectedOUT1, "_MMTest2");           
  }
  public void _MMTest3()
  {
      System.out.println("\n******************_MMTest3 ****************************************************");
      System.out.println("** Multiple ATs of the same type installed; Solution for one AT class preferred;*");
      System.out.println("** Solution for the other AT class is not indicated as preferred. ***************");        
      System.out.println("** The preferred one is among the installed solutions. **************************");
      System.out.println("\n**************************************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest3.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest3OUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest3");           
  }
  public void _MMTest4a()
  {
      System.out.println("\n******************_MMTest4a ***************************");
      System.out.println("** No AT of the type required by the user is installed.*");
      System.out.println("** No Magnifier on Windows. ****************************");
      System.out.println("\n******************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest4a.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest4aOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest4a");           
  }
  public void _MMTest4b()
  {
      System.out.println("\n******************_MMTest4b ***************************");
      System.out.println("** No AT of the type required by the user is installed.*");
      System.out.println("** No Magnifier on Linux. ******************************");
      System.out.println("\n******************************************************");     
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest4b.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest4bOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest4b");           
  }
  public void _MMTest4c()
  {
      System.out.println("\n******************_MMTest4c ***************************");
      System.out.println("** No AT of the type required by the user is installed.**");
      System.out.println("** No Magnifier on Android. *****************************");
      System.out.println("\n DECT: NOATC RES: NOATC_RES_rangeVal*******************");
      System.out.println("\n*******************************************************");        
  
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest4c.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest4cOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest4c");           
  }
  public void _MMTest5a()
  {
      System.out.println("\n******************_MMTest5a **********************************************");
      System.out.println("** No Accessibility Setting of the type required by the user is installed.**");
      System.out.println("** No high contrast on android *************** *****************************");
      System.out.println("\n DECT: NOATC RES: NOATC_RES_singleVal*************************************");     
      System.out.println("\n*******************************************************");
      
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest5a.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest5aOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest5a");           
  }
  public void _MMTest5b()
  {
      System.out.println("\n******************_MMTest5b **********************************************");
      System.out.println("** Accessibility Setting of the type required by the user is installed but *");
      System.out.println("** related setting is not. *************************************************");        
      System.out.println("** High contrast on Linux but no yellow on black theme  ********************");
      System.out.println("** No conflict rule applied - **********************************************");     
      System.out.println("\n**************************************************************************");
      
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest5b.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest5bOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest5a");           
  }
  public void _MMTest6a()
  {
      System.out.println("\n******************_MMTest6a **********************************************");
      System.out.println("** Accessibility Setting can be addressed at different levels **************");
      System.out.println("** Font Size on Linux => OS and Browser ************************************");        
      System.out.println("** No conflict rule applied - ??? ******************************************");     
      System.out.println("\n**************************************************************************");
      
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest6a.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest6aOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest6a");           
  }
  public void _MMTest6b()
  {
      System.out.println("\n******************_MMTest6b **********************************************");
      System.out.println("** Accessibility Setting can be addressed at different levels **************");
      System.out.println("** Magnification on Windows => OS and Browser ******************************");        
      System.out.println("** NOTE : No conflict rule applied ??? *************************************");     
      System.out.println("\n**************************************************************************");
      
      String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest6b.json";
      String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest6bOUT.json";
      
      performTest(filepathIN, filepathExpectedOUT, "_MMTest6b");           
  }   
  private void _CombinedScenario1() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'CombinedScenario1' *************************************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/combinedScenario1.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/combinedScenarioOUT1.json";

    performTest(filepathIN, filepathExpectedOUT1, "_CombinedScenario1");
  }

  private void _CombinedScenario2() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'CombinedScenario2' *************************************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/combinedScenario2.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/combinedScenarioOUT2.json";

    performTest(filepathIN, filepathExpectedOUT1, "_CombinedScenario2");
  }

  private void _Alicia() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'Alica' *************************************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/alicia.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/aliciaOUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_Alicia");
  }

  private void _AliciaSz2() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'Alica  on Linux (Szenario 2) '**************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/aliciaSz2.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/aliciaSz2OUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_AliciaSz2");
  }

  private void _LiaAndManuel() {
    System.out.println("\n*****************************************************");
    System.out.println("* Testing 'Lia and Manuel (Demo 4) '*******************");
    System.out.println("* Conflict Resolution on Multi-User Login *************");
    System.out.println("*******************************************************");

    String filepathIN =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/preferences/liaAndManuel.json";
    String filepathExpectedOUT1 =
        System.getProperty("user.dir")
            + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/liaAndManuelOUT.json";

    performTest(filepathIN, filepathExpectedOUT1, "_LiaAndManuel");
  }

  public void test_transformOwlToJSONLD() {
    if (JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS) {
      if (JsonLDManager.getInstance().INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD) {
        System.out
            .println("\n*********************************************************************************************************************************");
        System.out
            .println("* Testing 'transformOwlToJSONLD' web service                                                                                    *");
        System.out
            .println("*                                                                                                                               *");
        System.out
            .println("* Please be patient. This process will take some minutes. The whole solutions ontology is being transformed into JSON-LD format.*");
        System.out
            .println("* You can disable this test by setting in config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false  *");
        System.out
            .println("*********************************************************************************************************************************");

        Client client = Client.create();
        WebResource webResource =
            client.resource("http://localhost:8080/RBMM/transformOwlToJSONLD");
        ClientResponse response = webResource.get(ClientResponse.class);
        String output = response.getEntity(String.class);

        System.out.println("\nWeb service output:\n");
        System.out.println(output);

        // assertEquals(output, expectedOutputJsonStr);
      } else {
        System.out
            .println("\n******************************************************************************************************************************************************************************");
        System.out
            .println("* Testing of 'transformOwlToJSONLD' was skipped because it's a time consuming process (config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false) *");
        System.out
            .println("******************************************************************************************************************************************************************************\n");
      }
    } else
      System.out
          .println("test_transformOwlToJSONLD INTEGRATION TEST WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");
  }

  private void performTest(String filepathIN, String filepathExpectedOUT1, String test) {

    String filepathActualOUT =
        System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/debug/5_RBMMJsonOutput.json";

    String inputJsonStr = null;
    String actualOutputStr = null;
    String expectedOutputJsonStr1 = null;

    // read input & expected output
    try {
      inputJsonStr = Utils.getInstance().readFile(filepathIN);
      expectedOutputJsonStr1 = Utils.getInstance().readFile(filepathExpectedOUT1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Client client = Client.create();
    WebResource webResource = client.resource("http://localhost:8080/RBMM/runJSONLDRules");
    ClientResponse response =
        webResource.accept("application/json").type("application/json")
            .post(ClientResponse.class, inputJsonStr);
    String output = response.getEntity(String.class);

    System.out.println("\nWeb service output:\n");
    System.out.println(output);

    // read actual output
    try {
      actualOutputStr = Utils.getInstance().readFile(filepathActualOUT);
    } catch (IOException e) {
      e.printStackTrace();
    }

    boolean outputIsSimilarToOneOfTheExpected = false;
    if (actualOutputStr.equals(expectedOutputJsonStr1))
      outputIsSimilarToOneOfTheExpected = true;
    else {
      System.out.println("\n* ERROR -> " + test + " INTEGRATION TEST FAILED!");
      // System.exit(-1);
    }
    assertEquals(outputIsSimilarToOneOfTheExpected, true);
  }

}
