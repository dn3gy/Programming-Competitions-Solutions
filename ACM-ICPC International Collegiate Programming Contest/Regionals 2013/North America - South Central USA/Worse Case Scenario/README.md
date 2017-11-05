# How I Approached This Problem
Me being very confident in Java over the other programming languages I decided that I would write this problem in Java. Whatever programming language you are comfortable with, stick with that. After reading the problem we try to extract the important information that would help us to solve this problem.
## Thinking About What The Problem Is Asking for
The key points to take from the reading are:
  * There are 4 stages: A, B, C, D, arranged from lowest infection to the highest
  * When an infection event occurs in a zone, it will, worst-case scenario, cause the zone to advance in stage
  * A zone in stage D cannot advance in stage any further and will, worst-case scenario, result in an outbreak for each additional infection event it experiences
  * When an outbreak occurs, all neighboring zones experience an additional infection event
  * An outbreak can cause a chain reaction of outbreaks, but an outbreak can only cause a maximum of one outbreak in each zone
  * Zones marked with an X character are impassible and unpopulated areas that cannot become infected
  * An adjacent zone is one zone above, below, to the left, or to the right on the grid of zones
  * During an outbreak, the infection cannot spread diagonally
  * You will receive a grid of zones with their starting stages and a sequence of infection events with the coordinates of the zones in which they occur
  * Each infection event should be processed before calculating the result of the next infection event
Now sometimes the problem could seem intimidating and make no sense whatsoever, I have had those moments and it happens, but looking at the inputs and corresponding outputs or reading the problem over again can help you understand the problem more throughly.
