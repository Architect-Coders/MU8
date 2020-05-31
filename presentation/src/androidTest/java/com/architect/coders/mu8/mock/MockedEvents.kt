package com.architect.coders.mu8.mock

val mockedEventsResponse = """
{
    "code": 200,
    "status": "Ok",
    "copyright": "© 2020 MARVEL",
    "attributionText": "Data provided by Marvel. © 2020 MARVEL",
    "attributionHTML": "<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>",
    "etag": "9d551dac2bca10cc1dd17cba7d06a7d5b25a7a0f",
    "data": {
        "offset": 0,
        "limit": 100,
        "total": 75,
        "count": 75,
        "results": [
            {
                "id": 116,
                "title": "Acts of Vengeance!",
                "description": "Loki sets about convincing the super-villains of Earth to attack heroes other than those they normally fight in an attempt to destroy the Avengers to absolve his guilt over inadvertently creating the team in the first place.",
                "resourceURI": "http://gateway.marvel.com/v1/public/events/116",
                "urls": [
                    {
                        "type": "detail",
                        "url": "http://marvel.com/comics/events/116/acts_of_vengeance?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "wiki",
                        "url": "http://marvel.com/universe/Acts_of_Vengeance!?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    }
                ],
                "modified": "2013-06-28T16:31:24-0400",
                "start": "1989-12-10 00:00:00",
                "end": "2008-01-04 00:00:00",
                "thumbnail": {
                    "path": "http://i.annihil.us/u/prod/marvel/i/mg/9/40/51ca10d996b8b",
                    "extension": "jpg"
                },
                "creators": {
                    "available": 103,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/116/creators",
                    "items": [],
                    "returned": 20
                },
                "characters": {
                    "available": 103,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/116/characters",
                    "items": [],
                    "returned": 20
                },
                "stories": {
                    "available": 160,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/116/stories",
                    "items": [],
                    "returned": 20
                },
                "comics": {
                    "available": 52,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/116/comics",
                    "items": [],
                    "returned": 20
                },
                "series": {
                    "available": 22,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/116/series",
                    "items": [],
                    "returned": 20
                },
                "next": {
                    "resourceURI": "http://gateway.marvel.com/v1/public/events/240",
                    "name": "Days of Future Present"
                },
                "previous": {
                    "resourceURI": "http://gateway.marvel.com/v1/public/events/233",
                    "name": "Atlantis Attacks"
                }
            },
            {
                "id": 227,
                "title": "Age of Apocalypse",
                "description": "In a twisted version of the world they knew, the X-Men battle against the eternal mutant Apocalypse as Bishop seeks to repair the timeline. Legion, Xavier's own son, attempts to kill off all of Xavier's enemies; however, when Legion attempts to murder Magneto, Xavier sacrifices his own life to save Magnus. As a result, Magneto casts off his anti-human sentiments and carries on Xavier's dream of peaceful co-existence, thereby founding the X-Men.",
                "resourceURI": "http://gateway.marvel.com/v1/public/events/227",
                "urls": [
                    {
                        "type": "detail",
                        "url": "http://marvel.com/comics/events/227/age_of_apocalypse?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "wiki",
                        "url": "http://marvel.com/universe/Age_of_Apocalypse?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    }
                ],
                "modified": "2014-06-13T11:42:39-0400",
                "start": "1995-03-01 00:00:00",
                "end": "1996-06-01 00:00:00",
                "thumbnail": {
                    "path": "http://i.annihil.us/u/prod/marvel/i/mg/5/e0/51ca0e08a6546",
                    "extension": "jpg"
                },
                "creators": {
                    "available": 111,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/227/creators",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/807",
                            "name": "Comicraft",
                            "role": "letterer"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/3626",
                            "name": "Pat Brosseau",
                            "role": "letterer"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/452",
                            "name": "Virtual Calligr",
                            "role": "letterer"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/5898",
                            "name": "Derek",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/1945",
                            "name": "Mark Bernardo",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/1909",
                            "name": "Steve Buccellato",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/2974",
                            "name": "Digital Chameleon",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/13348",
                            "name": "Liquid! Color",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/4101",
                            "name": "Electric Crayon",
                            "role": "colorist"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/5991",
                            "name": "Toinay",
                            "role": "inker"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/11063",
                            "name": "Terry Kevin Austin",
                            "role": "inker"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/71",
                            "name": "Mark Buckingham",
                            "role": "inker"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/972",
                            "name": "Kevin Conrad",
                            "role": "inker"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/937",
                            "name": "Renato Arlem",
                            "role": "penciler"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/506",
                            "name": "Joe Bennett",
                            "role": "penciler"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/1288",
                            "name": "Jerry Bingham",
                            "role": "penciler"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/1192",
                            "name": "Ian Churchill",
                            "role": "penciler"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/232",
                            "name": "Chris Bachalo",
                            "role": "penciller"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/5268",
                            "name": "Jim Calafiore",
                            "role": "penciller"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/creators/3572",
                            "name": "Kelly Corvese",
                            "role": "editor"
                        }
                    ],
                    "returned": 20
                },
                "characters": {
                    "available": 91,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/227/characters",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009149",
                            "name": "Abyss"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1010903",
                            "name": "Abyss (Age of Apocalypse)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009153",
                            "name": "Angel (Warren Worthington III)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009156",
                            "name": "Apocalypse"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009158",
                            "name": "Arcade"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009159",
                            "name": "Archangel"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009163",
                            "name": "Aurora"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009168",
                            "name": "Banshee"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009596",
                            "name": "Banshee (Theresa Rourke)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009175",
                            "name": "Beast"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009182",
                            "name": "Bishop"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009197",
                            "name": "Blink"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009199",
                            "name": "Blob"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009205",
                            "name": "Boomer"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009210",
                            "name": "Brute"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009214",
                            "name": "Cable"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1010912",
                            "name": "Callisto (Age of Apocalypse)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009219",
                            "name": "Cannonball"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009223",
                            "name": "Captain Britain"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009261",
                            "name": "Carol Danvers"
                        }
                    ],
                    "returned": 20
                },
                "stories": {
                    "available": 197,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/227/stories",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/6850",
                            "name": "X-Men Chronicles 1-2; Tales from the AOA: By the Light",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/7272",
                            "name": "X-Calibre 2-3, Astonishing X-Men 2-4, Generation Next 2-3, X-Man 2-3, Factor X 3, Amazing X-Men 3, Gambit & The X-Ternals 3, X-U",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/7273",
                            "name": "X-Calibre 2-3, Astonishing X-Men 2-4, Generation Next 2-3, X-Man 2-3, Factor X 3, Amazing X-Men 3, Gambit & The X-Ternals 3, X-U",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/24492",
                            "name": "Interior #24492",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/24493",
                            "name": "Endings",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/24495",
                            "name": "Racing the Night",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/26280",
                            "name": "X-Men: Alpha (1994) #1",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/26281",
                            "name": "A Beginning",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32818",
                            "name": "Cover #32818",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32819",
                            "name": "Some of Us Looking to the Stars",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32820",
                            "name": "X-Facts: The Dream is Over",
                            "type": "text article"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32821",
                            "name": "Cover #32821",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32822",
                            "name": "Where No External Has Gone Before",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32823",
                            "name": "X-Facts: Reality Checked",
                            "type": "text article"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32824",
                            "name": "Cover #32824",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32825",
                            "name": "To the Limits of Infinity",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32826",
                            "name": "X-Facts: Where Have All The Heroes Gone?",
                            "type": "text article"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32827",
                            "name": "Cover #32827",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32828",
                            "name": "The Maze",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/32829",
                            "name": "X-Facts: Final Reflections",
                            "type": ""
                        }
                    ],
                    "returned": 20
                },
                "comics": {
                    "available": 50,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/227/comics",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17701",
                            "name": "AGE OF APOCALYPSE: THE CHOSEN 1 (1995) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17731",
                            "name": "Amazing X-Men (1995) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17732",
                            "name": "Amazing X-Men (1995) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17733",
                            "name": "Amazing X-Men (1995) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17734",
                            "name": "Amazing X-Men (1995) #4"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17735",
                            "name": "Astonishing X-Men (1995) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17736",
                            "name": "Astonishing X-Men (1995) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17737",
                            "name": "Astonishing X-Men (1995) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17738",
                            "name": "Astonishing X-Men (1995) #4"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17870",
                            "name": "Blink (2001) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17871",
                            "name": "Blink (2001) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17872",
                            "name": "Blink (2001) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17873",
                            "name": "Blink (2001) #4"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/20044",
                            "name": "Factor X (1995) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/20045",
                            "name": "Factor X (1995) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/20046",
                            "name": "Factor X (1995) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/20047",
                            "name": "Factor X (1995) #4"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/16077",
                            "name": "Gambit and the X-Ternals (1995) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/16078",
                            "name": "Gambit and the X-Ternals (1995) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/16079",
                            "name": "Gambit and the X-Ternals (1995) #3"
                        }
                    ],
                    "returned": 20
                },
                "series": {
                    "available": 20,
                    "collectionURI": "http://gateway.marvel.com/v1/public/events/227/series",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3614",
                            "name": "AGE OF APOCALYPSE: THE CHOSEN 1 (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3618",
                            "name": "Amazing X-Men (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3619",
                            "name": "Astonishing X-Men (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3628",
                            "name": "Blink (2001)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3737",
                            "name": "Factor X (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2578",
                            "name": "Gambit and the X-Ternals (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3734",
                            "name": "Generation Next (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3676",
                            "name": "Tales from the Age of Apocalypse: Sinster Bloodlines (1997)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3675",
                            "name": "Tales from the Age of Apocalyspse: By the Light (1996)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3635",
                            "name": "Weapon X (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3644",
                            "name": "X-Calibre (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3643",
                            "name": "X-Man (1995 - 2000)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3642",
                            "name": "X-MAN ANNUAL 1 (1996 - 1997)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3640",
                            "name": "X-Men Chronicles (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2104",
                            "name": "X-Men: Alpha (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2101",
                            "name": "X-Men: Omega (1995)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1452",
                            "name": "X-Men: The Complete Age of Apocalypse Epic Book 1 (2005)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1583",
                            "name": "X-Men: The Complete Age of Apocalypse Epic Book 2 (2005)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1684",
                            "name": "X-Men: The Complete Age of Apocalypse Epic Book 3 (2006)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1685",
                            "name": "X-Men: The Complete Age of Apocalypse Epic Book 4 (2006)"
                        }
                    ],
                    "returned": 20
                },
                "next": {
                    "resourceURI": "http://gateway.marvel.com/v1/public/events/239",
                    "name": "Crossing"
                },
                "previous": {
                    "resourceURI": "http://gateway.marvel.com/v1/public/events/219",
                    "name": "Siege of Darkness"
                }
            }
        ]
    }
}
""".trimIndent()
