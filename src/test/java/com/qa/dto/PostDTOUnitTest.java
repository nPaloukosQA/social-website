package com.qa.dto;

import com.qa.domain.Post;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PostDTOUnitTest {

    private Long pid = 1L;
    private PostDTO testPostDTO;
    private PostDTO testPostDTOWithID;
    private PostDTO testOtherPostDTO;
    private PostDTO testOtherPostDTOWithID;

    @Before
    public void setUp(){
        testPostDTO = new PostDTO("mylink");
        testPostDTOWithID = new PostDTO("myOthertestpic");
        testPostDTOWithID.setPid(pid);
        testOtherPostDTO = new PostDTO("mylink");
        testOtherPostDTOWithID = new PostDTO("myOthertestpic");
        testOtherPostDTOWithID.setPid(pid);
    }

    @Test
    public void gettersAndSettersTest(){
        assertNotNull(testPostDTOWithID.getPid());
        assertNotNull(testPostDTOWithID.getPictureLink());

        testPostDTOWithID.setPid(null);
        assertNull(testPostDTOWithID.getPid());
        testPostDTOWithID.setPictureLink(null);
        assertNull(testPostDTOWithID.getPictureLink());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(testPostDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(testPostDTO.equals(new Object()));
    }

    @Test
    public void checkEquality() {
        assertTrue(testPostDTO.equals(testPostDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(testOtherPostDTO.equals(testPostDTO));
    }

    @Ignore
    @Test
    public void postPIDNullButOtherRarityNotNull() {
        testPostDTO.setPid(null);
        assertFalse(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void itemPIDNotEqual() {
        testOtherPostDTO.setPid(3L);
        assertFalse(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullPID() {
        testPostDTO.setPid(null);
        testOtherPostDTO.setPid(null);
        assertTrue(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void nullId() {
        testPostDTOWithID.setPid(null);
        assertFalse(testPostDTOWithID.equals(testOtherPostDTOWithID));
    }

    @Test
    public void nullIdOnBoth() {
        testPostDTOWithID.setPid(null);
        testOtherPostDTOWithID.setPid(null);
        assertTrue(testPostDTOWithID.equals(testOtherPostDTOWithID));
    }

    @Test
    public void otherIdDifferent() {
        testOtherPostDTOWithID.setPid(2L);
        assertFalse(testPostDTOWithID.equals(testOtherPostDTOWithID));
    }

    @Test
    public void nullpicturelink() {
        testPostDTO.setPictureLink(null);
        assertFalse(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void nullpicturelinkOnBoth() {
        testPostDTO.setPictureLink(null);
        testOtherPostDTO.setPictureLink(null);
        assertTrue(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void otherpicturelinkDifferent() {
        testOtherPostDTO.setPictureLink("alink");
        assertFalse(testPostDTO.equals(testOtherPostDTO));
    }

    @Test
    public void constructorWithoutId() {
        PostDTO simple = new PostDTO("greatlink");
        assertNull(simple.getPid());
        assertNotNull(simple.getPictureLink());
    }


}
