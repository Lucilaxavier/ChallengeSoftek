package br.com.softmind.presentation.ui.tips

object TipsProvider {
    private val tips = listOf(
        "Remember to take breaks during work.",
        "Talk to colleagues about your well-being.",
        "Practice breathing exercises to relieve stress.",
        "Record your mood daily to track your progress.",
        "Seek support from available channels whenever necessary."
    )

    fun getRandomTip(): String {
        return tips.random()
    }
}
