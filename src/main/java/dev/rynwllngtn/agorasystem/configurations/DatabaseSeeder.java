package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
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
import java.util.Random;
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

            Profile profile = new Profile();
            profile.setProfileOwner(UUID.randomUUID());
            profile.setUserName(String.format("Random profile %d", i));
            profile.setBirthDate(new Date());
            profileRepository.save(profile);

            Post post = new Post();
            post.setAuthor(new AuthorDTO(profile));
            post.setTitle(String.format("Post from profile %s", profile.getUserName()));
            post.setBody("Random post!");
            post.setDate(new Date());
            postRepository.save(post);

            Comment comment = new Comment();
            comment.setAuthor(new AuthorDTO(profile));
            comment.setBody("Random comment!");
            commentRepository.save(comment);

            post.getComments().add(comment);
            postRepository.save(post);

            profile.getPosts().add(post);
            profileRepository.save(profile);
        }

        IO.println("Database seeded successfully!");
    }

}