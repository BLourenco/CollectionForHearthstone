1. Update the extractor from the github link.
2. Follow the readme on github, using the '.paket' stuff.
3. Create or copy the runner in the solution.
4. Run the runner.
5. Pass the output files through the bulk resizer, down to 160x160 at ~80% quality.
6. Pass those through the bulk rename utility, making sure all letters are lowercase.
7. Copy/Paste the files into the android project's drawable folder.
8. Verify all images are appearing in their corresponding list item. Rename the file to match the card id if image is not appearing.
9. Push to Bitbucket.