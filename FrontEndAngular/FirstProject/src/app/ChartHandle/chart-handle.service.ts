import { Injectable } from '@angular/core';
import * as CanvasJS from '../canvasjs.min';

@Injectable({
  providedIn: 'root'
})
export class ChartHandleService {

  constructor() { }

  public showChartRatyRowne(data: any): void {
    this.showChart(data, 'chartContainerRatyRowne', 'Raty Rowne');
  }

  public showChartRatyMalejace(data: any): void {
    this.showChart(data, 'chartContainerRatyMalejace', 'Raty Malejace');
  }

  private showChart(data: any, chartName: string, title: string): void {
    const chart = new CanvasJS.Chart(chartName, {
      theme: 'light2',
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: title
      },
      data: [{
        type: 'pie',
        showInLegend: true,
        toolTipContent: '<b>{name}</b>: {y} (#percent%)',
        indexLabel: '{name} - {y} PLN',
        dataPoints: data
      }]
    });
    chart.render();
  }
}
