package academy.devdojo.springboot2essentials.util;

import academy.devdojo.springboot2essentials.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Dragon")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Yugioh")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdateAnime() {
        return Anime.builder()
                .name("Yugioh 2")
                .id(1L)
                .build();
    }
}
