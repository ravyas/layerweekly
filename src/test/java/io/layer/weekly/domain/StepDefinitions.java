package io.layer.weekly.domain;

import io.layer.weekly.dao.LayerWeeklyMagazineRepository;
import io.layer.weekly.domain.users.CopyWriter;
import io.layer.weekly.domain.users.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.layer.weekly.service.LayerWeeklyMagazineService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private LayerWeeklyMagazineService layerWeeklyMagazineService = new LayerWeeklyMagazineService(new LayerWeeklyMagazineRepository());

    @Given("^Layer weekly magazine edition kicked off$")
    public void layer_weekly_magazine_edition_kicked_off() throws Exception {
        layerWeeklyMagazineService.kickOffNewEdition();
    }

    @When("^Chief editor add topic to magazine edition$")
    public void chief_editor_add_topic_to_magazine_edition() throws Exception {
        addTopic();
    }

    private void addTopic() throws InvalidUserException {
        User user = new User(User.Role.CHIEFEDITOR);
        layerWeeklyMagazineService.currentEdition().addTopic(user, new Topic("Environmental warming"));
    }

    @Then("^Topics successfully added to magazine edition$")
    public void topics_successfully_added_to_magazine_edition() throws Exception {
        assertEquals(1, layerWeeklyMagazineService.currentEdition().getTopics().size());
    }

    @Given("^Topics has been added to the new edition$")
    public void topics_has_been_added_to_the_new_edition() throws Exception {
        layerWeeklyMagazineService.kickOffNewEdition();
        addTopic();
    }

    @When("^Journalist submits draft article$")
    public void journalist_submits_draft_article() throws InvalidUserException {
        DraftArticle global_warming = createDraftArticle();
        layerWeeklyMagazineService.currentEdition().submitDraftArticle(new User(User.Role.JOURNALIST), global_warming);
    }

    private DraftArticle createDraftArticle() {
        String title = "Antarctica Ice meltdown";
        String content = "Global warming has become a severe problem. Several species extincted in past few years.";
        ArrayList<Topic> connectedTopics = new ArrayList<>();
        connectedTopics.add(new Topic("Global warming"));
        connectedTopics.add(new Topic("South pole"));
        DraftArticle global_warming = new DraftArticle(title, content, connectedTopics);
        return global_warming;
    }

    @Then("^Draft article saved and can be accessed by Copywriters$")
    public void draft_article_saved_and_can_be_accessed_by_Copywriters() {
        assertEquals(1, layerWeeklyMagazineService.currentEdition().getDraftArticles().size());
    }

    @Given("^Draft article has been published by journalist$")
    public void draft_article_has_been_published_by_journalist() throws InvalidUserException {
        layerWeeklyMagazineService.kickOffNewEdition();
        addTopic();
        layerWeeklyMagazineService.currentEdition().submitDraftArticle(new User(User.Role.JOURNALIST), createDraftArticle());
    }

    @When("^Copywriter suggest changes to article$")
    public void copywriter_suggest_changes_to_article() throws InvalidUserException {
        layerWeeklyMagazineService.currentEdition().getDraftArticles().get(0).suggestChanges(new CopyWriter(), Arrays.asList("Fix the heading"));
    }

    @Then("^Suggested changes are saved for article and can be accessed by journalist$")
    public void suggested_changes_are_saved_for_article_and_can_be_accessed_by_journalist() {
        assertEquals(1, layerWeeklyMagazineService.currentEdition().getDraftArticles().get(0).getSuggestedChanges().size());
    }

}
