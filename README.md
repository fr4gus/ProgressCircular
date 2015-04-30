# ProgressCircular
![ProgressCircular in Action](http://github.com/fr4gus/ProgressCircular/raw/master/doc/images/preview.png)
Similar to ProgressBar Android Widget, except that this is circular (but is not undefined as standard widget, yet).

## How to use it

1. Add the following line in your build.gradle

```
dependencies {
    compile 'com.fr4gus:progresscircular:1.0.0-SNAPSHOT'
}
```

2. Add the widget in your XML Layout file
```xml
        <com.fr4gus.android.widget.ProgressCircular
            android:layout_width="@dimen/progress_size"
            android:layout_height="@dimen/progress_size"
            android:textColor="#fff"
            android:textSize="12sp"
            progressCircular:current="0"
            progressCircular:strokeWidth="4dp"
            progressCircular:currentColor="#8BC34A"
            progressCircular:remainingColor="#2E7D32"
            progressCircular:showPercentage="false"
            progressCircular:total="100"
            />
```
## The details

This widget can be used as a different way to present data, like porcentages or remaining tasks, achivementes, to complete.
It can be used also as a progress bar and "animate" as tasks or progress is completed.

* `current` Is the current value of the progress circular. It's a number between 0 (inclusive) and "total" which is defined in anothe property
* `total` Is the maximum value the progress can go. The number must be a value greater than zero.
* `strokeWidth` How strong the stroke will be.
* `curentColor` The color of the line (curve) that represents current progress. When `current` is equals to `total` this will be the color of the whole circle.
* `remainingColor` The color of the line (curve) that represents remaining progress. When `current` is zero, this is the color of the whole cricle.
* `showPercentage` If `true` this means that no matter the total set, the text draw inside will display the porcentage of `current` based on `total`. For example if you set `total` as 200 and `current` is 50, the widget will display 25. If `false` will display `current` value as it is.


## License

    Copyright 2015 Franklin Garcia

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.