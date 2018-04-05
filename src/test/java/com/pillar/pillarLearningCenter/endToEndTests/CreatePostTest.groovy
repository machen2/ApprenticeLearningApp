package com.pillar.pillarLearningCenter.endToEndTests
import geb.junit4.GebTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class CreatePostTest extends GebTest {

    @Test
    void postsNewView_ShouldRedirectToPostsView_WhenSubmitButtonClicked() {
        go "http://localhost:8080/posts/new"

        $("input").click()

        assert $("h1")[0].text() == "Posts"
    }
}
