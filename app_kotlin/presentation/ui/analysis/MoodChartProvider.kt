package br.com.softmind.presentation.ui.analysis

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

object MoodChartProvider {
    fun setupChart(chart: LineChart, data: List<Pair<Int, Float>>) {
        val entries = data.map { Entry(it.first.toFloat(), it.second) }
        val dataSet = LineDataSet(entries, "Mood Evolution")
        dataSet.setDrawValues(false)
        dataSet.setDrawCircles(true)
        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()
    }
}
