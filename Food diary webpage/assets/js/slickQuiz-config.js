// Setup your quiz text and questions here

// NOTE: pay attention to commas, IE struggles with those bad boys

var quizJSON = {
    
    "info": {
        "name":    "지현이는 무슨 음식을 좋아할까?",
        "main":    "<p>지현이의 식성 파악 퀴즈! 지현이를 제대로 알고 있나요?</p>",
        "results": "<h5>어때요? 지현이 식성 참 특이하죠? </h5><p>이제는 이 내용을 바탕으로 지현이에게 음식을 건네주며 친하게 지내보세요! </p>",
        "level1":  "지현이 본인이신가봐요..?",
        "level2":  "지현이 박사 : 꽤 아시네요?",
        "level3":  "지현이랑 꽤 친한가봐요..",
        "level4":  "지현이랑 가까이 지내보세요...",
        "level5":  "지현이랑 좀 더 친해지세요~^^" 
    },
    "questions": [
        { // Question 1
            "q": "다음 중 지현이가 가장 싫어하는 음식은? ",
            "a": [
                {"option": "닭가슴살 샐러드",     "correct": false},
                {"option": "토마토 스파게티",     "correct": false},
                {"option": "오이",     "correct": false},
                {"option": "마라탕",     "correct": false},
                {"option": "유부 초밥",     "correct": true},
                {"option": "민트초코",     "correct": false} 
            ],
            "correct": "<p><span>참 잘했어요! 다음 문제도 꼭 맞추세요! </span>지현이가 유부초밥을 먹지 않는 이유는 당시 지현이가 7살이던 시절, 유치원 소풍을 나갔다가 상한 유부초밥을 먹고 체한 적이 있어 다시는 먹지 않기 때문입니다.</p>",
            "incorrect": "<p><span>심하시군요! 지현이는 초밥 세트 먹을 때 유부 초밥은 빼먹고 먹는다는 사실 모르나요? </span> 지현이가 유부초밥을 먹지 않는 이유는 당시 지현이가 7살이던 시절, 유치원 소풍을 나갔다가 상한 유부초밥을 먹고 체한 적이 있어 다시는 먹지 않기 때문입니다.</p>" 
        },
        { // Question 2
            "q": "지현이가 제일 좋아하는 밥 반찬은?",
            "a": [
                {"option": "계란말이",    "correct": true},
                {"option": "멸치볶음",     "correct": false},
                {"option": "도라지무침",     "correct": false},
                {"option": "동그랑땡",     "correct": false}

            ],
            "correct": "<p><span>정답~^^지현이는 계란말이를 좋아해요~</span>눈에 확 띄는 색감과 영양가도 있고 쉽게 구할 수 있는 재료, 거기다 숙련도가 매우 필요하다는 점에서 정성이 들어간 메뉴라는 느낌이 드는 보들보들하고 맛있는 계란말이...</p>",
            "incorrect": "<p><span>틀렸어요ㅠㅠ 지현이는 계란말이를 좋아합니다...</span>눈에 확 띄는 색감과 영양가도 있고 쉽게 구할 수 있는 재료, 거기다 숙련도가 매우 필요하다는 점에서 정성이 들어간 메뉴라는 느낌이 드는 보들보들하고 맛있는 계란말이...</p>" 
        },
        { // Question 3
            "q": "번외: 지금 이 웹페이지를 퀴즈를 만들면서 지현이가 섭취하고 있는 것은?",
            "a": [
                {"option": "코코아",             "correct": true},
                {"option": "초콜릿",           "correct": false},
                {"option": "커피",          "correct": false},
                {"option": "아무것도 안 먹고 있다",          "correct": false} 
            ],
            "correct": "<p><span>아니 이건 어떻게 맞췄죠?</span>2019.12.06. 아침 7시 30분, 지현이는 방에서 따뜻한 코코아를 마시며 퀴즈를 만들고 있습니다.</p>",
            "incorrect": "<p><span>다음 문제는 꼭 맞춰보세요ㅠㅠㅠ</span> 2019.12.06. 아침 7시 30분, 지현이는 방에서 따뜻한 코코아를 마시며 퀴즈를 만들고 있습니다.</p>" 
        },
        { // Question 4
            "q": "지현이가 서브웨이(Subway) 메뉴 중 가장 좋아하는 메뉴는 베지(Vegy)이다.",
            "a": [
                {"option": "O",    "correct": true},
                {"option": "X",     "correct": false} 
            ],
            "correct": "<p><span>GOOD JOB!</span>지현이는 다음 수업까지 시간이 많이 없으면 서브웨이를 먹습니다. 특이하게도, 샌드위치에는 야채만 다 넣고, 후추, 올리브오일을 소스로 골라 밍밍하고 맛없다고 여겨지는 베지를 즐겨먹습니다. </p>",
            "incorrect": "<p><span>WRONG...TRY NEXT TIME...</span> 지현이는 다음 수업까지 시간이 많이 없으면 서브웨이를 먹습니다. 특이하게도, 샌드위치에는 야채만 다 넣고, 후추, 올리브오일을 소스로 골라 밍밍하고 맛없다고 여겨지는 베지를 즐겨먹습니다. </p>"
        },
        { // Question 5
            "q": "다음 중 지현이가 먹을 수 있는 음식을 모두 고르시오!",
            "a": [
                {"option": "닭발",   "correct": true},
                {"option": "번데기",          "correct": true},
                {"option": "돼지껍데기",  "correct": true},
                {"option": "홍어",     "correct": false},
                {"option": "육회",     "correct": true},
                {"option": "순대",  "correct": true},
                {"option": "생간",     "correct": false} 
            ],
            "correct": "<p><span>이 문제를 맞추시다니....정말 대단하시군요!</span>지현이가 모든 음식을 다 먹을 수 있을 줄 알았죠? 사실 지현이 자기자신도 그런줄만 알았어요. 그런데 홍어 삼합이랑 생간은 정말 식감이랑 냄새가 지현이를 불편하게 만드네요.</p>",
            "incorrect": "<p><span>흠. 그래요. 이건 틀릴 수 있죠.</span>지현이가 모든 음식을 다 먹을 수 있을 줄 알았죠? 사실 지현이 자기자신도 그런줄만 알았어요. 그런데 홍어 삼합이랑 생간은 정말 식감이랑 냄새가 지현이를 불편하게 만드네요.</p>" 
        } // no comma here
    ]
};