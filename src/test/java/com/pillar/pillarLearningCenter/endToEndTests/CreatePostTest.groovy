package com.pillar.pillarLearningCenter.endToEndTests

import geb.junit4.GebTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@RunWith(JUnit4)
@DataJpaTest
class CreatePostTest extends GebTest {

    @Test
    void postsNewView_ShouldRedirect_WhenSubmitButtonClicked() {
        go "http://localhost:8080/posts/new"

        $("form").title = "New Title - in memory"
        $("form").content = "Content here"
        $("input", value: "Submit").click()

        assert $("h1")[0].text() == "Posts"
    }
}
