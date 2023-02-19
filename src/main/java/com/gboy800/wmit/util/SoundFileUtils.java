package com.gboy800.wmit.util;

public class SoundFileUtils {

    public static String fileNametoSong(String fileName) {
        return switch (fileName) {
            case "menu1" -> "Mutation";
            case "menu2" -> "Moog City 2";
            case "menu3" -> "Beginning 2";
            case "menu4" -> "Floating Trees";
            case "credits" -> "Alpha";
            case "calm1" -> "Minecraft";
            case "calm2" -> "Clark";
            case "calm3" -> "Sweden";
            case "creative1" -> "Biome Fest";
            case "creative2" -> "Blind Spots";
            case "creative3" -> "Haunt Muskie";
            case "creative4" -> "Aria Math";
            case "creative5" -> "Dreiton";
            case "creative6" -> "Taswell";
            case "hal1" -> "Subwoofer Lullaby";
            case "hal2" -> "Living Mice";
            case "hal3" -> "Haggstrom";
            case "hal4" -> "Danny";
            case "nuance1" -> "Key";
            case "nuance2" -> "Oxygène";
            case "piano1" -> "Dry Hands";
            case "piano2" -> "Wet Hands";
            case "piano3" -> "Mice on Venus";
            case "aerie" -> "Aerie";
            case "ancestry" -> "Ancestry";
            case "an_ordinary_day" -> "An Ordinary Day";
            case "comforting_memories" -> "Comforting Memories";
            case "firebugs" -> "Firebugs";
            case "floating_dream" -> "Floating Dream";
            case "infinite_amethyst" -> "Infinite Amethyst";
            case "labyrinthine" -> "Labyrinthine";
            case "left_to_bloom" -> "Left To Bloom";
            case "one_more_day" -> "One More Day";
            case "stand_tall" -> "Stand Tall";
            case "wending" -> "Wending";
            case "axolotl" -> "Axolotl";
            case "dragon_fish" -> "Dragon Fish";
            case "shunji" -> "Shunji";
            case "nether1" -> "Concrete Halls";
            case "nether2" -> "Dead Voxel";
            case "nether3" -> "Warmth";
            case "nether4" -> "Ballad of the Cats";
            case "chrysopoeia" -> "Chrysopoeia";
            case "rebedo" -> "Rubedo";
            case "so_below" -> "So Below";
            case "boss" -> "Boss";
            case "end" -> "The End";
            default -> fileName;
        };
    }

}
