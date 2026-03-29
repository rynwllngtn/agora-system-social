package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
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

    @Override
    public void run(String... args) {

        if (profileRepository.count() > 0) {
            return;
        }

        int feederAmount = 10;
        for (int i = 1; i <= feederAmount; i++) {
            Profile profile = new Profile();
            profile.setProfileOwner(UUID.randomUUID());
            profile.setUserName(String.format("Profile Number %d", i));
            profile.setBirthDate(new Date());
            profileRepository.save(profile);

            Post post = new Post();
            post.setAuthor(new AuthorDTO(profile));
            post.setTitle(String.format("Post from profile %s", profile.getUserName()));
            post.setBody("Random comment!");
            post.setDate(new Date());
            postRepository.save(post);

        }

        IO.println("Database seeded successfully!");
    }

}