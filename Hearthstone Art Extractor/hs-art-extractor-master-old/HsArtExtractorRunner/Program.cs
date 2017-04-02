using HsArtExtractor;
using HsArtExtractor.Hearthstone;
using HsArtExtractor.Util;

class Program
{
    private static void Main(string[] args)
    {
        // set the logging level and location
        Logger.SetLogLevel(LogLevel.WARN);
        Logger.SetLogLocation(@"D:\Repos\Hearthstone Art Extractor");

        // do the extraction
        Extract.CardArt(new CardArtExtractorOptions()
        {
            HearthstoneDir = @"D:\Program Files (x86)\Hearthstone",
            OutputDir = @"D:\Repos\Hearthstone Art Extractor\Output",
            MapFile = "CardArtDefs.xml",
            Height = 160,
            BarHeight = 35,
            ImageType = "jpg"
        });
    }
}