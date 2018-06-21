# wanghanting

Flu Epidemic
Ca y est - la grippe est arrivée chez nous ! This project is a simulation of a flu (influenza) epidemic. Obviously this will be a simplification of real-world epidemics. The simulation consists of both a disease model describing characteristics of the illness, and a social model describing how people interact with each other.

We start with the basic element of the simulation – a person. We'll abstract away most of the details we associate with people since only a few qualities interest us. At any given time, a person can be in one (or more) of several states:

Healthy: healthy people can become sick only after they come in contact with people who are contagious. But not always - this depends on the infection rate of the disease, only some percentage of exposed people may become ill.
Infected: after contact with a contagious person, a healthy person may become infected. An infected person carries the various but displays no symptoms. An infected person may also become contagious after an incubation period.
Sick: an infected person may become sick, ie, they display symptoms of the disease. They remain infected.
Contagious: a few days (let's say two days - this is the incubation time) after infection, a sick person becomes contagious and may transmit the disease to other people with whom they come into contact. They remain infected.
Recovering: some time after becoming contagious (let's say three days for our simulation, a person either gets over the illness and starts recovering, or...dies of the illness. A recovering person is no longer infected nor contagious and becomes healthy again after three more days. A recovered person cannot be re-infected.
Dead: depending on the mortality rate of the disease, a person may recover or die. A dead person stays dead.
For the moment, the times in the simulation disease model are fixed, eg, becoming contagious takes two days after infection. However, the infection and mortality rates remain to be determined.

The simulation also consists of three other elements: chickens, ducks and pigs. These have much the same behaviour as people, they can be in the same states and they can be infectious (chickens and ducks can infect each other with the H5N1 virus, pigs infect pigs with the H1N1 virus ) with different incubation times and mortality rates. However, infected animals never die of the infection. Rarely, an animal can infect a person with its virus, which people can then pass on to other people as described above.

The social model describes the behaviour of the simulation elements. They all live together on a two-dimensional grid and are in contact with other elements situated within a neighbourhood on the grid. The notion of neighbourhood is a parameter of the simulation, eg, this can be the 4-neighbourhood of row and column neighbours, or the 8-neighbourhood which includes diagonal neighbours, or some other neighbourhood. An element does not necessarily contact all of its neighbours; perhaps a fixed number or some percentage. Contagious elements can infect healthy elements they come into contact with, within the rules given above.

The simulation itself proceeds by steps of a day at a time. The grid is initialized with all people being healthy, but with some animals already being sick with their specific virus. At the first step, each element determines which state they should next assume, and so on. The simulation ends when there is no more change, all entities are either healthy or dead.

Note that this in not a graphics simulation, everything should work from the command line and the only output permitted is from System.out.print[ln]. You will have to come up with some way to visually represent entities in their different states on the grid.

Variants
There are lots of possibilities, including:

Individual characteristics which can affect the infection rate, eg, different inherent resistance to the disease, or different habits such as frequent hand-washing.
Individual characteristics which can affect the mortality rate, eg, a general fitness level.
Someone who has been exposed and has recovered develops antibodies which confer resistance to infection.
Different population patterns, ie, not every grid point has to be populated.
Some individuals may be vaccinated against the viruses.
Elements may move on the grid.
Changing weather can change infection rates.
Invent your own...
Constraints
The development language is Java.
Code must be professional - clean and commented.
Code must be tested.
You must implement at least one variant. But...still no graphic interfaces.
Code work will be under git version control at github. Code should be committed frequently.
Project delivery is on github.
Along with the code, deliverables also include a Readme.txt file with instructions on how to run the application from the command line.
You work individually. You may collaborate to some extent, but each submission is individual (it's really too bad to have to mention this!).
Unconstraints
Use the development tool of your choice. You will get the most support using Sublime Text 3.
Use the operating system of your choice. You will get the most support using Linux.
Use the hardware of your choice.