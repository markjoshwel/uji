# uji

![uji icon](des/icon-colour@2x.png)

a silly android (8.0+) app that just sends you a high priority notification every 18 minutes

based and named after [fewstuff](https://twitter.com/fewstufff/)'s original character
that is as follows:

> its a robot girl whos purpose is to announce every time 18 minutes have passed.
> based on my feelings OF USELESSNES and being liability at werk

<https://twitter.com/fewstufff/status/1790129630503919748> \
<https://twitter.com/fewstufff/status/1791133555340247277> \
<https://twitter.com/fewstufff/status/1791203693934555284>

botched together after also wanting to have something that bugs me every 18 minutes \
(and after needing an excuse to pick up kotlin and jetpack compose)

- [x] icon
- [x] basic application
  - [x] reoccurring notifications  
    (UselessAnnouncement, UselessScheduler, UselessAnnouncementReceiver, NotificationMailman)
  - [ ] turning on and off alarms  
    (NotificationMailman, StateManager)
  - [ ] resuming alarm on boot  
    (UselessStartupReceiver)
  - [ ] adaptive icon
  - [ ] ui
  - [ ] quick settings tile

## credits and love

- character idea and design by [fewstuff](https://twitter.com/fewstufff/)
- notification messages from posts
  by [fewstuff](https://twitter.com/fewstufff/status/1791133555340247277),
  [mafuyunaa](https://twitter.com/mafuyunaa/status/1790460882352316805)
  and [0iichi](https://twitter.com/0iichi/status/1790910083154481508)
- [vector uji head icon](des/) by me
- kaomojis ripped out of windows 11's clipboard

## technical deets

- **ui** \
  [jetpack compose](https://developer.android.com/develop/ui/compose) +
  [material 3](https://developer.android.com/develop/ui/compose/designsystems/material3)

- **state storage** \
  [jetpack proto datastore](https://developer.android.com/topic/libraries/architecture/datastore)

- is [**direct boot**](https://developer.android.com/privacy-and-security/direct-boot) aware

that's it

> she is not interesting in any fun way like that

## licence

everything EXCEPT icon assets is free and unencumbered software released into the public domain \
for more information, please refer to [UNLICENCE](UNLICENCE) or <http://unlicense.org/>

see below for glob patterns in which files that fall under it are **all rights reserved**:

- `des/*`
