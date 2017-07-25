package com.rt_rk.jefimijana.vod;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    public static List<Movie> list;

    public static List<Movie> setupMovies() {
        list = new ArrayList<Movie>();

        //Prepare static Movies data
        String movies[] = {
                "The wolf of wall street",
                "Rush",
                "Dark knight rises",
                "How to train your dragon 2",
                "The Expendables 3",
                "The amazing spider man 2",
                "22 jump street",
                "Guardians of the galaxy",
                "Maleficent",
                "Toy story 3",
                "Despicable me 2",
                "Space jam",
                "Godzilla",
                "What if",
                "Lets be cops"
        };

        String moviesDescription[] = {
                "In 1987, Jordan Belfort procures a job as a Wall Street stockbroker for L.F. Rothschild, employed under Mark Hanna, who quickly entices him with the sex- and drugs-fueled stockbroker culture and teaches him that a stockbroker's only job is to make money for himself. Jordan soon finds his career terminated following Black Monday and takes a job at a boiler room brokerage firm on Long Island that specializes in penny stocks. Thanks to his aggressive pitching style and the high commissions, Jordan makes a small fortune.",
                "In the mid-1970s, charismatic English playboy James Hunt (Chris Hemsworth) and Austrian perfectionist Niki Lauda (Daniel Brühl) share an intense rivalry in Formula 1 racing. Driving vehicles that are little more than gas-filled, rolling bombs, Hunt and Lauda burn up the track, all the while pushing themselves to the breaking point of physical and mental endurance. Meanwhile, the women (Olivia Wilde, Alexandra Maria Lara) in their lives can only watch as both drivers risk death with every lap.",
                "It has been eight years since Batman (Christian Bale), in collusion with Commissioner Gordon (Gary Oldman), vanished into the night. Assuming responsibility for the death of Harvey Dent, Batman sacrificed everything for what he and Gordon hoped would be the greater good. However, the arrival of a cunning cat burglar (Anne Hathaway) and a merciless terrorist named Bane (Tom Hardy) force Batman out of exile and into a battle he may not be able to win.",
                "Five years have passed since Hiccup and Toothless united the dragons and Vikings of Berk. Now, they spend their time charting the island's unmapped territories. During one of their adventures, the pair discover a secret cave that houses hundreds of wild dragons -- and a mysterious dragon rider who turns out to be Hiccup's long-lost mother, Valka (Cate Blanchett). Hiccup and Toothless then find themselves at the center of a battle to protect Berk from a power-hungry warrior named Drago.",
                "Years ago, Barney Ross (Sylvester Stallone) co-founded the Expendables with Conrad Stonebanks (Mel Gibson). After Stonebanks became an arms dealer, Ross was forced to kill him -- or so he thought. Now, Stonebanks is back and he's on a mission to end the Expendables. Ross decides that the way to fight old blood is with new blood, so he assembles a team of younger, faster, more tech-savvy recruits. The battle to topple Stonebanks becomes a clash of old-school methods vs. high-tech expertise.",
                "Confident in his powers as Spider-Man, Peter Parker (Andrew Garfield) embraces his new role as a hero and spends time with Gwen Stacy (Emma Stone) in between protecting New York from criminals. However, his greatest battle yet is about to begin. With the emergence of Electro (Jamie Foxx), Peter must confront an enemy far more powerful than he is. And when his old friend Harry Osborn (Dane DeHaan) returns, Peter comes to realize that all his enemies have one thing in common: Oscorp.",
                "Although they made their way through high school successfully, an investigation at a local college brings big changes for undercover officers Jenko (Channing Tatum) and Schmidt (Jonah Hill). When Jenko meets a kindred spirit on the football team and Schmidt infiltrates the bohemian art-major scene, both men begin to question their partnership. Not only do they have to crack the case, but now the two overgrown adolescents must learn how to behave like adults.",
                "Brash space adventurer Peter Quill (Chris Pratt) finds himself the quarry of relentless bounty hunters after he steals an orb coveted by Ronan, a powerful villain. To evade Ronan, Quill is forced into an uneasy truce with four disparate misfits: gun-toting Rocket Raccoon, treelike-humanoid Groot, enigmatic Gamora, and vengeance-driven Drax the Destroyer. But when he discovers the orb's true power and the cosmic threat it poses, Quill must rally his ragtag group to save the universe.",
                "As a beautiful young woman of pure heart, Maleficent (Angelina Jolie) has an idyllic life in a forest kingdom. When an invading army threatens the land, Maleficent rises up to become its fiercest protector. However, a terrible betrayal hardens her heart and twists her into a creature bent on revenge. She engages in an epic battle with the invading king's successor, then curses his newborn daughter, Aurora -- realizing only later that the child holds the key to peace in the kingdom.",
                "With their beloved Andy preparing to leave for college, Woody (Tom Hanks), Buzz Lightyear (Tim Allen), Jessie (Joan Cusack), and the rest of the toys find themselves headed for the attic but mistakenly wind up on the curb with the trash. Woody's quick thinking saves the gang, but all but Woody end up being donated to a day-care center. Unfortunately, the uncontrollable kids do not play nice, so Woody and the gang make plans for a great escape.",
                "Now that Gru (Steve Carell) has forsaken a life of crime to raise Margo, Agnes and Edith, he's trying to figure out how to provide for his new family. As he struggles with his responsibilities as a father, the Anti-Villain League -- an organization dedicated to fighting evil -- comes calling. The AVL sends Gru on a mission to capture the perpetrator of a spectacular heist, for who would be better than the world's greatest ex-villain to capture the individual who seeks to usurp his power.",
                "Swackhammer (Danny DeVito), an evil alien theme park owner, needs a new attraction at Moron Mountain. When his gang, the Nerdlucks, heads to Earth to kidnap Bugs Bunny (Billy West) and the Looney Tunes, Bugs challenges them to a basketball game to determine their fate. The aliens agree, but they steal the powers of NBA basketball players, including Larry Bird (Larry Bird) and Charles Barkley (Charles Barkley) -- so Bugs gets some help from superstar Michael Jordan (Michael Jordan).",
                "Ford Brody (Aaron Taylor-Johnson), a Navy bomb expert, has just reunited with his family in San Francisco when he is forced to go to Japan to help his estranged father, Joe (Bryan Cranston). Soon, both men are swept up in an escalating crisis when Godzilla, King of the Monsters, arises from the sea to combat malevolent adversaries that threaten the survival of humanity. The creatures leave colossal destruction in their wake, as they make their way toward their final battleground: San Francisco.",
                "A medical-school dropout (Daniel Radcliffe) tries to hide his attraction to his new friend (Zoe Kazan), a bubbly artist who already has a boyfriend.",
                "Best pals Ryan (Jake Johnson) and Justin (Damon Wayans Jr.) are stalled in their respective careers -- a fact that is painfully driven home when they go to a college reunion. Dressed as police in the mistaken belief that they were to attend a costume party, Ryan and Justin find that the uniforms earn them much respect and attention. Although Justin is uncomfortable with the idea, Ryan decides to continue with the charade, putting them both in increasingly dangerous situations."
        };

        String moviesImages[] = {
                "http://89.216.58.236/vod/posters/the_wolf_of_wall_street.jpg",
                "http://89.216.58.236/vod/posters/rush.jpg",
                "http://89.216.58.236/vod/posters/dark_knight_rises.jpg",
                "http://89.216.58.236/vod/posters/how_to_train_your_dragon_2.jpg",
                "http://89.216.58.236/vod/posters/the_expendables_3.jpg",
                "http://89.216.58.236/vod/posters/the_amazing_spider_man_2.jpg",
                "http://89.216.58.236/vod/posters/22_jump_street.jpg",
                "http://89.216.58.236/vod/posters/guardians_of_the_galaxy.jpg",
                "http://89.216.58.236/vod/posters/maleficent.jpg",
                "http://89.216.58.236/vod/posters/toy_story_3.jpg",
                "http://89.216.58.236/vod/posters/despicable_me_2.jpg",
                "http://89.216.58.236/vod/posters/space_jam.jpg",
                "http://89.216.58.236/vod/posters/godzilla.jpg",
                "http://89.216.58.236/vod/posters/what_if.jpg",
                "http://89.216.58.236/vod/posters/lets_be_cops.jpg"
        };

        String moviesBackgroundImages[] = {
                "http://89.216.58.236/vod/posters/the_wolf_of_wall_street_landscape.jpg",
                "http://89.216.58.236/vod/posters/rush_landscape.jpg",
                "http://89.216.58.236/vod/posters/dark_knight_rises_landscape.jpg",
                "http://89.216.58.236/vod/posters/how_to_train_your_dragon_2_landscape.jpg",
                "http://89.216.58.236/vod/posters/the_expendables_3_landscape.jpg",
                "http://89.216.58.236/vod/posters/the_amazing_spider_man_2_landscape.jpg",
                "http://89.216.58.236/vod/posters/22_jump_street_landscape.jpg",
                "http://89.216.58.236/vod/posters/guardians_of_the_galaxy_landscape.jpg",
                "http://89.216.58.236/vod/posters/maleficent_landscape.jpg",
                "http://89.216.58.236/vod/posters/toy_story_3_landscape.jpg",
                "http://89.216.58.236/vod/posters/despicable_me_2_landscape.jpg",
                "http://89.216.58.236/vod/posters/space_jam_landscape.jpg",
                "http://89.216.58.236/vod/posters/godzilla_landscape.jpg",
                "http://89.216.58.236/vod/posters/what_if_landscape.jpg",
                "http://89.216.58.236/vod/posters/lets_be_cops_landscape.jpg"
        };

        String moviesTrailers[] = {
                "http://89.216.58.236/vod/trailers/the_wolf_of_wall_street_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/rush_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/the_dark_knight_rises_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/how_to_train_your_dragon_2_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/the_expendables_3_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/the_amazing_spider_man_2_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/22_jump_street_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/guardians_of_the_galaxy_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/maleficent_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/toy_story_3_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/despicable_me_2_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/space_jam_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/godzilla_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/what_if_official_trailer.mp4",
                "http://89.216.58.236/vod/trailers/lets_be_cops_official_trailer.mp4"
        };

        String moviesDirectors[] = {
                "Director Name 1",
                "Director Name 2",
                "Director Name 3",
                "Director Name 4",
                "Director Name 5",
                "Director Name 6",
                "Director Name 7",
                "Director Name 8",
                "Director Name 9",
                "Director Name 10",
                "Director Name 11",
                "Director Name 12",
                "Director Name 13",
                "Director Name 14",
                "Director Name 15",
        };

        //TODO: Use lists instead
        String moviesStars[] = {
                "Actor 1, Actress 1, Actress 1",
                "Actor 2, Actress 2",
                "Actor 3, Actress 3",
                "Actor 4, Actress 4, Actress 4",
                "Actor 5, Actress 5",
                "Actor 6, Actress 6",
                "Actor 7, Actress 7, Actor 7",
                "Actor 8, Actress 8",
                "Actor 9, Actress 9",
                "Actor 10,Actress 10",
                "Actor 11, Actress 11",
                "Actor 12, Actress 12",
                "Actor 13, Actress 13",
                "Actor 14, Actress 14",
                "Actor 15, Actress 15",
        };

        String moviesDuration[] = {
                "126 min",
                "89 min",
                "134 min",
                "222 min",
                "152 min",
                "156 min",
                "178 min",
                "133 min",
                "111 min",
                "100 min",
                "99 min",
                "67 min",
                "107 min",
                "208 min",
                "230 min",
        };

        String moviesGenre[] = {
                "Action",
                "Action, Adventure",
                "Sci-Fi",
                "Animation",
                "Action, Adventure",
                "Action, Sci-Fi, Adventure",
                "Comedy",
                "Adventure, Action",
                "Animation, Sci-Fi, Adventure",
                "Animation",
                "Animation, Action",
                "Animation",
                "Horror, Action, Sci-Fi",
                "Thriller",
                "Action, Comedy"
        };

        String moviesRatings[] = {
                "PG-1",
                "PG-2",
                "PG-3",
                "PG-4",
                "PG-5",
                "PG-6",
                "PG-7",
                "PG-8",
                "PG-9",
                "PG-10",
                "PG-11",
                "PG-12",
                "PG-13",
                "PG-14",
                "PG-15",

        };

        String moviesPrices[] = {
                "2 \u20ac",
                "2,3 \u20ac",
                "2,2 \u20ac",
                "3,1 \u20ac",
                "3 \u20ac",
                "1,6 \u20ac",
                "1,8 \u20ac",
                "1,9 \u20ac",
                "2,1 \u20ac",
                "3,2 \u20ac",
                "2,2 \u20ac",
                "1,9 \u20ac",
                "4 \u20ac",
                "3,6 \u20ac",
                "2,6 \u20ac",
        };

        //Add movies to the public static list
        for (int i = 0; i < movies.length; i++) {
            list.add(buildMovieInfo(
                    movies[i],
                    moviesDescription[i],
                    moviesTrailers[i],
                    moviesImages[i],
                    moviesBackgroundImages[i],
                    moviesDuration[i],
                    moviesGenre[i],
                    moviesRatings[i],
                    moviesPrices[i],
                    moviesDirectors[i],
                    moviesStars[i]));
        }

        return list;
    }

    private static Movie buildMovieInfo(String title, String desctiption, String videoUrl, String cardImageUrl, String bgImageUrl, String duration, String genre, String rating, String price, String director, String stars) {
        Movie movie = new Movie();
        movie.setId(Movie.getCount());
        Movie.incCount();
        movie.setTitle(title);
        movie.setDescription(desctiption);
        movie.setCardImageUrl(cardImageUrl);
        movie.setBackgroundImageUrl(bgImageUrl);
        movie.setVideoUrl(videoUrl);

        movie.setDuration(duration);
        movie.setGenre(genre);
        movie.setRating(rating);
        movie.setPrice(price);
        movie.setDirector(director);
        movie.setStars(stars);

        return movie;
    }
}
