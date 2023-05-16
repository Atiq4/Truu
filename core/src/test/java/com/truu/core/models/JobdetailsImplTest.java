package com.truu.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class JobdetailsImplTest {
   private final AemContext aemContext=new AemContext();
   Jobdetails jobdetails;
    @BeforeEach
    public void setUp() throws Exception {
        aemContext.addModelsForClasses(JobdetailsImpl.class);
        aemContext.load().json("/Jobdetails.json", "/component");

    }

    @Test
    void getKeyskills() {
      aemContext.currentResource("/component/jobdetails");
      jobdetails=aemContext.request().adaptTo(Jobdetails.class);
      assertEquals(4,jobdetails.getKeyskills().size());
      assertEquals(jobdetails.getKeyskills().get(0), "1.5+ years of relevant work experience");
      assertEquals(jobdetails.getKeyskills().get(1), "Strong knowledge of HTML/CSS/Vanilla Javascript/ReactJS");
      assertEquals(jobdetails.getKeyskills().get(2), "Web responsive design implementation");
      assertEquals(jobdetails.getKeyskills().get(3), "Basic knowledge of NextJS");
    }

    @Test
    void getJobskills() {
        aemContext.currentResource("/component/jobdetails");
        jobdetails=aemContext.request().adaptTo(Jobdetails.class);
        assertEquals(4,jobdetails.getJobskills().size());
        assertEquals(jobdetails.getJobskills().get(0), "Passion for web development");
        assertEquals(jobdetails.getJobskills().get(1), "Ability to estimate your own work and effectively communicate progress and escalate issues");
        assertEquals(jobdetails.getJobskills().get(2), "Ability and willingness to learn and constantly improve");
        assertEquals(jobdetails.getJobskills().get(3), "To be a supportive team player");
    }
}