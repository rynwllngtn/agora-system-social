package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.repositories.comment.CommentRepository;
import dev.rynwllngtn.agorasystem.repositories.post.PostRepository;
import dev.rynwllngtn.agorasystem.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.UUID;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void run(String... args) {

        if (profileRepository.count() > 0) {
            return;
        }

        int feederAmount = 10;
        for (int i = 1; i <= feederAmount; i++) {

            Profile profile = buildProfile(i);
            profileRepository.save(profile);

            Post post = buildPost(profile);
            postRepository.save(post);

            Comment comment = buildComment(post, profile);
            commentRepository.save(comment);
        }

        IO.println("Database seeded successfully!");
    }

    private Profile buildProfile(int i) {
        Profile profile = new Profile();
        profile.setProfileOwner(UUID.randomUUID());
        profile.setUserName(String.format("Random profile %d", i));
        profile.setBirthDate(new Date());
        return profile;
    }

    private Post buildPost(Profile author) {
        Post post = new Post();
        post.setAuthor(new AuthorDTO(author));
        post.setTitle(String.format("Post from profile %s", author.getUserName()));
        post.setBody("Random post!");
        return post;
    }

    private Comment buildComment (Post post, Profile author) {
        Comment comment = new Comment();
        comment.setAuthor(new AuthorDTO(author));
        comment.setPost(new CommentPostDTO(post));
        comment.setBody("Random comment!");
        return comment;
    }

}