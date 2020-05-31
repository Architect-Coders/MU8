package com.architect.coders.mu8.mock

val mockedCharactersResponse = """
{
    "code": 200,
    "status": "Ok",
    "copyright": "© 2020 MARVEL",
    "attributionText": "Data provided by Marvel. © 2020 MARVEL",
    "attributionHTML": "<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>",
    "etag": "98a7a76684c243aa603ab4110452c7ce118c04a2",
    "data": {
        "offset": 0,
        "limit": 20,
        "total": 1493,
        "count": 20,
        "results": [
            {
                "id": 1011334,
                "name": "3-D Man",
                "description": "",
                "modified": "2014-04-29T14:18:17-0400",
                "thumbnail": {
                    "path": "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                    "extension": "jpg"
                },
                "resourceURI": "http://gateway.marvel.com/v1/public/characters/1011334",
                "comics": {
                    "available": 12,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/comics",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/21366",
                            "name": "Avengers: The Initiative (2007) #14"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/24571",
                            "name": "Avengers: The Initiative (2007) #14 (SPOTLIGHT VARIANT)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/21546",
                            "name": "Avengers: The Initiative (2007) #15"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/21741",
                            "name": "Avengers: The Initiative (2007) #16"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/21975",
                            "name": "Avengers: The Initiative (2007) #17"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/22299",
                            "name": "Avengers: The Initiative (2007) #18"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/22300",
                            "name": "Avengers: The Initiative (2007) #18 (ZOMBIE VARIANT)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/22506",
                            "name": "Avengers: The Initiative (2007) #19"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/8500",
                            "name": "Deadpool (1997) #44"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/10223",
                            "name": "Marvel Premiere (1972) #35"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/10224",
                            "name": "Marvel Premiere (1972) #36"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/10225",
                            "name": "Marvel Premiere (1972) #37"
                        }
                    ],
                    "returned": 12
                },
                "series": {
                    "available": 3,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/series",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1945",
                            "name": "Avengers: The Initiative (2007 - 2010)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2005",
                            "name": "Deadpool (1997 - 2002)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2045",
                            "name": "Marvel Premiere (1972 - 1981)"
                        }
                    ],
                    "returned": 3
                },
                "stories": {
                    "available": 21,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/stories",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19947",
                            "name": "Cover #19947",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19948",
                            "name": "The 3-D Man!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19949",
                            "name": "Cover #19949",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19950",
                            "name": "The Devil's Music!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19951",
                            "name": "Cover #19951",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/19952",
                            "name": "Code-Name:  The Cold Warrior!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47184",
                            "name": "AVENGERS: THE INITIATIVE (2007) #14",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47185",
                            "name": "Avengers: The Initiative (2007) #14 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47498",
                            "name": "AVENGERS: THE INITIATIVE (2007) #15",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47499",
                            "name": "Avengers: The Initiative (2007) #15 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47792",
                            "name": "AVENGERS: THE INITIATIVE (2007) #16",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/47793",
                            "name": "Avengers: The Initiative (2007) #16 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/48361",
                            "name": "AVENGERS: THE INITIATIVE (2007) #17",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/48362",
                            "name": "Avengers: The Initiative (2007) #17 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/49103",
                            "name": "AVENGERS: THE INITIATIVE (2007) #18",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/49104",
                            "name": "Avengers: The Initiative (2007) #18 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/49106",
                            "name": "Avengers: The Initiative (2007) #18, Zombie Variant - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/49888",
                            "name": "AVENGERS: THE INITIATIVE (2007) #19",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/49889",
                            "name": "Avengers: The Initiative (2007) #19 - Int",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/54371",
                            "name": "Avengers: The Initiative (2007) #14, Spotlight Variant - Int",
                            "type": "interiorStory"
                        }
                    ],
                    "returned": 20
                },
                "events": {
                    "available": 1,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/events",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/events/269",
                            "name": "Secret Invasion"
                        }
                    ],
                    "returned": 1
                },
                "urls": [
                    {
                        "type": "detail",
                        "url": "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "wiki",
                        "url": "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "comiclink",
                        "url": "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    }
                ]
            },
            {
                "id": 1017100,
                "name": "A-Bomb (HAS)",
                "description": "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
                "modified": "2013-09-18T15:54:04-0400",
                "thumbnail": {
                    "path": "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
                    "extension": "jpg"
                },
                "resourceURI": "http://gateway.marvel.com/v1/public/characters/1017100",
                "comics": {
                    "available": 3,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1017100/comics",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/40632",
                            "name": "Hulk (2008) #53"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/40630",
                            "name": "Hulk (2008) #54"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/40628",
                            "name": "Hulk (2008) #55"
                        }
                    ],
                    "returned": 3
                },
                "series": {
                    "available": 2,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1017100/series",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/17765",
                            "name": "FREE COMIC BOOK DAY 2013 1 (2013)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3374",
                            "name": "Hulk (2008 - 2012)"
                        }
                    ],
                    "returned": 2
                },
                "stories": {
                    "available": 7,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1017100/stories",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92078",
                            "name": "Hulk (2008) #55",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92079",
                            "name": "Interior #92079",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92082",
                            "name": "Hulk (2008) #54",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92083",
                            "name": "Interior #92083",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92086",
                            "name": "Hulk (2008) #53",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/92087",
                            "name": "Interior #92087",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/105929",
                            "name": "cover from Free Comic Book Day 2013 (Avengers/Hulk) (2013) #1",
                            "type": "cover"
                        }
                    ],
                    "returned": 7
                },
                "events": {
                    "available": 0,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1017100/events",
                    "items": [],
                    "returned": 0
                },
                "urls": [
                    {
                        "type": "detail",
                        "url": "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "comiclink",
                        "url": "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    }
                ]
            },
            {
                "id": 1009144,
                "name": "A.I.M.",
                "description": "AIM is a terrorist organization bent on destroying the world.",
                "modified": "2013-10-17T14:41:30-0400",
                "thumbnail": {
                    "path": "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec",
                    "extension": "jpg"
                },
                "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009144",
                "comics": {
                    "available": 49,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1009144/comics",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/36763",
                            "name": "Ant-Man & the Wasp (2010) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/17553",
                            "name": "Avengers (1998) #67"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/7340",
                            "name": "Avengers (1963) #87"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/4214",
                            "name": "Avengers and Power Pack Assemble! (2006) #2"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/63217",
                            "name": "Avengers and Power Pack (2017) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/63218",
                            "name": "Avengers and Power Pack (2017) #4"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/63219",
                            "name": "Avengers and Power Pack (2017) #5"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/63220",
                            "name": "Avengers and Power Pack (2017) #6"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/64790",
                            "name": "Avengers by Brian Michael Bendis: The Complete Collection Vol. 2 (Trade Paperback)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/1170",
                            "name": "Avengers Vol. 2: Red Zone (Trade Paperback)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/1214",
                            "name": "Avengers Vol. II: Red Zone (Trade Paperback)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/12787",
                            "name": "Captain America (1998) #28"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/7513",
                            "name": "Captain America (1968) #132"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/7514",
                            "name": "Captain America (1968) #133"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/65466",
                            "name": "Captain America by Mark Waid, Ron Garney & Andy Kubert (Hardcover)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/20367",
                            "name": "Defenders (1972) #57"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/31068",
                            "name": "Incredible Hulks (2010) #606 (VARIANT)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/46168",
                            "name": "Indestructible Hulk (2012) #3"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/43944",
                            "name": "Iron Man (2012) #1"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/comics/9544",
                            "name": "Iron Man (1968) #295"
                        }
                    ],
                    "returned": 20
                },
                "series": {
                    "available": 33,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1009144/series",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/13082",
                            "name": "Ant-Man & the Wasp (2010 - 2011)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/354",
                            "name": "Avengers (1998 - 2004)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1991",
                            "name": "Avengers (1963 - 1996)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/23123",
                            "name": "Avengers and Power Pack (2017)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1046",
                            "name": "Avengers and Power Pack Assemble! (2006)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/23600",
                            "name": "Avengers by Brian Michael Bendis: The Complete Collection Vol. 2 (2017)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/227",
                            "name": "Avengers Vol. 2: Red Zone (2003)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/271",
                            "name": "Avengers Vol. II: Red Zone (2003)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1996",
                            "name": "Captain America (1968 - 1996)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1997",
                            "name": "Captain America (1998 - 2002)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/23810",
                            "name": "Captain America by Mark Waid, Ron Garney & Andy Kubert (2017)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/3743",
                            "name": "Defenders (1972 - 1986)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/8842",
                            "name": "Incredible Hulks (2010 - 2011)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/16583",
                            "name": "Indestructible Hulk (2012 - 2014)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/16593",
                            "name": "Iron Man (2012 - 2014)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/2029",
                            "name": "Iron Man (1968 - 1996)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/23915",
                            "name": "Iron Man Epic Collection: Doom (2018)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/9718",
                            "name": "Marvel Adventures Super Heroes (2010 - 2012)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/189",
                            "name": "Marvel Masterworks: Captain America Vol. 1 - 2nd Edition (2003)"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/series/1506",
                            "name": "MARVEL MASTERWORKS: CAPTAIN AMERICA VOL. 1 HC (2005)"
                        }
                    ],
                    "returned": 20
                },
                "stories": {
                    "available": 52,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1009144/stories",
                    "items": [
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/5800",
                            "name": "Avengers and Power Pack Assemble! (2006) #2",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/5801",
                            "name": "2 of 4 - 4XLS",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10253",
                            "name": "When the Unliving Strike",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10255",
                            "name": "Cover #10255",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10256",
                            "name": "The Enemy Within!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10259",
                            "name": "Death Before Dishonor!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10261",
                            "name": "Cover #10261",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/10262",
                            "name": "The End of A.I.M.!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11921",
                            "name": "The Red Skull Lives!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11930",
                            "name": "He Who Holds the Cosmic Cube",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11936",
                            "name": "The Maddening Mystery of the Inconceivable Adaptoid!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11981",
                            "name": "If This Be... Modok",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11984",
                            "name": "A Time to Die -- A Time to Live!",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/11995",
                            "name": "At the Mercy of the Maggia",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/15243",
                            "name": "Look Homeward, Avenger",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/17518",
                            "name": "Captain America (1968) #132",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/17519",
                            "name": "The Fearful Secret of Bucky Barnes",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/17520",
                            "name": "Captain America (1968) #133",
                            "type": "cover"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/17521",
                            "name": "Madness In the Slums",
                            "type": "interiorStory"
                        },
                        {
                            "resourceURI": "http://gateway.marvel.com/v1/public/stories/28233",
                            "name": "In Sin Airy X",
                            "type": "interiorStory"
                        }
                    ],
                    "returned": 20
                },
                "events": {
                    "available": 0,
                    "collectionURI": "http://gateway.marvel.com/v1/public/characters/1009144/events",
                    "items": [],
                    "returned": 0
                },
                "urls": [
                    {
                        "type": "detail",
                        "url": "http://marvel.com/comics/characters/1009144/aim.?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "wiki",
                        "url": "http://marvel.com/universe/A.I.M.?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    },
                    {
                        "type": "comiclink",
                        "url": "http://marvel.com/comics/characters/1009144/aim.?utm_campaign=apiRef&utm_source=6c12dd58dd0ee18b01eb92e65fa7cd26"
                    }
                ]
            }
        ]
    }
}
""".trimIndent()