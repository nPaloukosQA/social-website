package com.qa.domain;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PostUnitTest {

    private Long pid = 1L;
    private Post testPost;
    private Post testPostWithID;
    private Post testOtherPost;
    private Post testOtherWithID;

    @Before
    public void setUp(){
        testPost = new Post("mylink");
        testPostWithID = new Post("myOthertestpic");
        testPostWithID.setPid(pid);
        testOtherPost = new Post("mylink");
        testOtherWithID = new Post("myOthertestpic");
        testOtherWithID.setPid(pid);
    }

    @Test
    public void gettersAndSettersTest(){
        assertNotNull(testPostWithID.getPid());
        assertNotNull(testPostWithID.getPictureLink());

        testPostWithID.setPid(null);
        assertNull(testPostWithID.getPid());
        testPostWithID.setPictureLink(null);
        assertNull(testPostWithID.getPictureLink());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(testPost.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(testPost.equals(new Object()));
    }

    @Test
    public void checkEquality() {
        assertTrue(testPost.equals(testPost));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(testOtherPost.equals(testPost));
    }

    @Ignore
    @Test
    public void postPIDNullButOtherRarityNotNull() {
        testPost.setPid(null);
        assertFalse(testPost.equals(testOtherPost));
    }

    @Test
    public void itemPIDNotEqual() {
        testOtherPost.setPid(3L);
        assertFalse(testPost.equals(testOtherPost));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullPID() {
        testPost.setPid(null);
        testOtherPost.setPid(null);
        assertTrue(testPost.equals(testOtherPost));
    }

    @Test
    public void nullId() {
        testPostWithID.setPid(null);
        assertFalse(testPostWithID.equals(testOtherWithID));
    }

    @Test
    public void nullIdOnBoth() {
        testPostWithID.setPid(null);
        testOtherWithID.setPid(null);
        assertTrue(testPostWithID.equals(testOtherWithID));
    }

    @Test
    public void otherIdDifferent() {
        testOtherWithID.setPid(2L);
        assertFalse(testPostWithID.equals(testOtherWithID));
    }

    @Test
    public void nullpicturelink() {
        testPost.setPictureLink(null);
        assertFalse(testPost.equals(testOtherPost));
    }

    @Test
    public void nullpicturelinkOnBoth() {
        testPost.setPictureLink(null);
        testOtherPost.setPictureLink(null);
        assertTrue(testPost.equals(testOtherPost));
    }

    @Test
    public void otherpicturelinkDifferent() {
        testOtherPost.setPictureLink("alink");
        assertFalse(testPost.equals(testOtherPost));
    }

    @Test
    public void constructorWithoutId() {
        Post simple = new Post("greatlink");
        assertNull(simple.getPid());
        assertNotNull(simple.getPictureLink());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(testPost.hashCode(), testOtherPost.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        Post post = new Post(null);
        post.setPid(null);
        Post otherPost = new Post(null);
        otherPost.setPid(null);
        assertEquals(post.hashCode(), otherPost.hashCode());
    }

}
