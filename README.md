# NLP_and_IR_for_CAA2019
Code and NLP/IR models done for CAA2019 Krakow (https://2019.caaconference.org/2018/05/10/welcome-to-krakow/)


# Combination of machine learning methods of image and natural language recognition on ancient coin data

Keywords: Natural Language Processing, Image Recognition, Convolutional Neural Network, Ancient Coins

Abstract: 

We are currently working to combine two machine learning methods: Image Recognition (IR) based on Convolutional Neural Networks (CNN) and Natural Language Processing (NLP). We already successfully implemented both approaches separately on numismatic data, more precisely on data from Online Coins of the Roman Empire (OCRE) and Corpus Nummorum Thracorum (CNT). Our goals by combining them is to further improve the overall performance (rate of correct results) and also to a) better understand the problems for each single method on these data and b) try to identify inconsistencies (errors) in the existing ground truth data. 
More precisely: The IR approach is trained to identify the portrait of roman emperors on the obverse side (currently we reach a Top 1 accuracy of 91%). The NLP method uses the coin descriptions entered by humans to locate subjects, objects and verbs. This way we can extract also the depicted person from the already existing description. 
The results of both methods are compared with the available type descriptions and checked for divergences/errors via transition to Resource Description Framework (RDF). Hence, together with our domain experts we can understand why these divergences happen and either correct the error or use this information for improvement during the retraining of the IR or NLP models.
So far, we are working mainly on coins of good quality. The challenge is to apply it also to coin finds with medium or poor quality, where it sometimes is even not easy to define the ground truth for it. 

